package pl.fiszki.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Bartek on 30.01.2017.
 */
@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {


    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);

        return "home";
    }


}
