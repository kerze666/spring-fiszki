package pl.fiszki.controllers.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserRole;
import pl.fiszki.models.user.UserStatus;
import pl.fiszki.service.UserRoleService;
import pl.fiszki.service.UserService;


/**
 * Created by Bartek on 18.04.2017.
 */

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(value = "/admin")
public class AdminController {

    private static Logger logger = Logger.getLogger(AdminController.class);

    private final UserService userService;

    private final UserRoleService userRoleService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserService userService, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("userlist", userService.findAllUsers());
        logger.warn("admin has logged.");
        return "admin/start";
    }

    @RequestMapping(value = "adduser", method = RequestMethod.GET)
    public String addUserSite(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "admin/addUser/adduser";
    }

    /**
     * TO DO add validate for params
     **/
    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addUserPost(Model model,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {

        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        if (!userService.isUser(username)) {
            /**create new user**/
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setStatus(UserStatus.ACTIVE);
            userService.createUser(user);

            /**
             * add roles for new user
             * get id from newly created user and set role = 1 // ROLE_USER
             **/
            UserRole userRole = new UserRole();
            userRole.setIdUserRole(2);
            userRole.setUserId(user.getId());
            userRoleService.addRolesUser(userRole);

            model.addAttribute("messageSucc", "Stworzono nowego użytkownika " + username);
        } else {
            model.addAttribute("messageErr", "Nie udało się utworzyć użytkownika " + username);
        }
        return "admin/addUser/adduser";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String deleteUserPost(Model model,
                                 @PathVariable long id
                                 ) {

        userService.deleteUser(id);
        model.addAttribute("message", "Użytkownik został pomyślnie usunięty");
        return "redirect:/admin";
    }


}