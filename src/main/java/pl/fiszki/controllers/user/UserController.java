package pl.fiszki.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.user.User;
import pl.fiszki.models.words.Category;
import pl.fiszki.service.UserService;
import pl.fiszki.service.WordService;
import pl.fiszki.service.impl.CategoryServiceImpl;

@Controller
@Secured("ROLE_USER")
@RequestMapping("user")
public class UserController {

    @Autowired
    private WordService wordService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String startUserSite(Model model) {
        User user = userService.getUserByUserNameAndStatus(SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("user", user);
        model.addAttribute("categories", categoryService.getCategoriesByUserId(user.getId()));


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
        User user = userService.getUserByUserNameAndStatus(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("username", user.getUsername());
        if (!categoryService.isCategory(nameOfCategory, user.getId())) {

            Category category = new Category();
            category.setCategory(nameOfCategory);
            category.setUserid(user.getId());

            categoryService.addCategory(category);

            model.addAttribute("message", "Dodałeś nową kategorię : " + nameOfCategory);

            return "redirect:/user";
        } else {
            model.addAttribute("message", "Posiadasz już taką kategorię w swojej fiszkotece !");

            return "user/newcategory";
        }
    }

    //USUNIĘCIE WSZYSTKICH SłÓWEK ORAZ DANEJ KATEGORII Z DANEJ KATEGORII
    @RequestMapping(value = "deleteCategory/{catId}", method = RequestMethod.POST)
    public String deleteCategory(Model model,
                                 @PathVariable long catId) {
        try {
            categoryService.deleteCategory(catId);
            wordService.deleteWordsByCatId(catId);// do dopracowania
            model.addAttribute("message", "Kategoria została usunięta");
        }catch (Exception e){
            System.out.println("You get a null in words");
        }
        return "redirect:/user";
    }


}
