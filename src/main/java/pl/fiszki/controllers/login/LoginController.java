package pl.fiszki.controllers.login;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserRole;
import pl.fiszki.models.user.UserStatus;
import pl.fiszki.service.UserRoleService;
import pl.fiszki.service.UserService;


@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping(value = "registry", method = RequestMethod.GET)
    public String signInSite() {
        return "registry/registry";
    }

    @RequestMapping(value = "registry", method = RequestMethod.POST)
    public String signIn(Model model,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("repassword") String repassword) {

        logger.warn("Is user in database: "+userService.isUser(username));
        if(password.equals(repassword)){
            logger.warn("Passowrd: "+password+ " - "+repassword);
            if (!userService.isUser(username)) {
                /**create new user**/
                User user = new User();
                user.setUsername(username);
                user.setPassword(passwordEncoder.encode(password));
                user.setStatus(UserStatus.ACTIVE);
                userService.createUser(user);

                UserRole userRole = new UserRole();
                userRole.setIdUserRole(2);
                userRole.setUserId(userService.findUserByUsername(username,UserStatus.ACTIVE).getId());
                userRoleService.addRolesUser(userRole);

                model.addAttribute("messageSucc", " Stworzono nowego użytkownika " + username+ " !");
            } else {
                model.addAttribute("message", " Istnieje już taki użytkownik !");
            }
        }else{
            model.addAttribute("message", " Błędne hasło !");
        }

        return "registry/registry";
    }

}
