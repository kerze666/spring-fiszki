package pl.fiszki.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.User;
import pl.fiszki.models.UserRole;
import pl.fiszki.models.UserStatus;
import pl.fiszki.service.UserRoleService;
import pl.fiszki.service.UserService;


@Controller
public class LoginController {

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


    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signInSite() {
        return "registry/signin";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String signIn(Model model,
                         @RequestParam("username") String username,
                         @RequestParam("password") String password) {
        if (userService.isUserInDatebase(username) == null) {
            /**create new user**/
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setStatus(UserStatus.ACTIVE);
            userService.addUser(user);

            UserRole userRole = new UserRole();
            userRole.setIdUserRole(2);
            userRole.setUserId(userService.getIdUserByUsername(username));
            userRoleService.addRolesUser(userRole);

            model.addAttribute("messageSucc", "Stworzono nowego użytkownika " + username);
        } else {
            model.addAttribute("messageErr", "Nie udało się utworzyć użytkownika " + username);
        }
        return "registry/signin";
    }

}
