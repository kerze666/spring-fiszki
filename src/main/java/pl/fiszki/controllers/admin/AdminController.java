package pl.fiszki.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bartek on 18.04.2017.
 */

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping
    public String start(){
        return "adminHome";
    }
}
