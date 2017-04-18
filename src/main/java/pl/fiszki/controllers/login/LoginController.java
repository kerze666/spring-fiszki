package pl.fiszki.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.fiszki.service.UserService;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/user-info")
    public String home(Model model, Authentication auth) {
        auth.getPrincipal();
        model.addAttribute("user", userService.getUserByUserNameAndStatus(auth.getName()));

        return "user-info";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }

}
