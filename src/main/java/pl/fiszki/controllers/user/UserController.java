package pl.fiszki.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.fiszki.service.UserService;
import pl.fiszki.service.WordService;

@Controller
@Secured("ROLE_USER")
@RequestMapping("user")
public class UserController {

    @Autowired
    private WordService wordService;

    @RequestMapping( method = RequestMethod.GET)
    public String startUserSite(Model model){
        model.addAttribute("username",SecurityContextHolder.getContext().getAuthentication().getName());
        /**
         * add list of categories
         * add menu (edit category, delete category, test with chosen category)
         * add new category
         * */
        return "user/start";
    }
    @RequestMapping(value = "addcategory",method = RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute("username",SecurityContextHolder.getContext().getAuthentication().getName());
        return "user/start";
    }


}
