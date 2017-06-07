package pl.fiszki.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContextUtils;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserStatus;
import pl.fiszki.models.words.Category;
import pl.fiszki.service.UserService;
import pl.fiszki.service.WordService;
import pl.fiszki.service.impl.CategoryServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@PreAuthorize("hasRole('USER')")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String startUserSite(Model model, @ModelAttribute(name = "message") String message) {
        User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName(), UserStatus.ACTIVE);

        model.addAttribute("message",message);
        model.addAttribute("user", user);
        model.addAttribute("adminWords", categoryService.findCategoriesByUser(userService.findUserByUsername("admin",UserStatus.ACTIVE)));
        model.addAttribute("categories", categoryService.findCategoriesByUser(user));

        return "user/start";
    }

    @RequestMapping(value = "addcategory", method = RequestMethod.GET)
    public String addCategorySite(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "user/newcategory";
    }

    @RequestMapping(value = "addcategory", method = RequestMethod.POST)
    public String addCategoryPost(Model model,
                                  @RequestParam(value = "category") String nameOfCategory) {

        User user = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName(), UserStatus.ACTIVE);

        model.addAttribute("username", user.getUsername());
        if (!categoryService.isCategory(nameOfCategory,user)) {

            Category category = new Category();
            category.setCategory(nameOfCategory);
            category.setUser(user);

            categoryService.addCategory(category);

            model.addAttribute("message", "Dodales nowa kategorie : " + nameOfCategory);
            model.addAttribute("categories", categoryService.findCategoriesByUser(user));
            model.addAttribute("adminWords", categoryService.findCategoryById(1));
            return "redirect:/user";
        } else {
            model.addAttribute("message", "Posiadasz już taką kategorie w swojej fiszkotece !");

            return "user/newcategory";
        }
    }

    //USUNIĘCIE WSZYSTKICH SłÓWEK ORAZ DANEJ KATEGORII Z DANEJ KATEGORII
    @RequestMapping(value = "deleteCategory/{catId}", method = RequestMethod.POST)
    public String deleteCategory(Model model,
                                 @PathVariable long catId) {
        try {
            categoryService.deleteCategory(catId);
            model.addAttribute("message", "Kategoria została usunięta");
        }catch (Exception e){
            System.out.println("You get a null in words");
        }
        return "redirect:/user";
    }


}
