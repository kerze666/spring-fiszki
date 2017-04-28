package pl.fiszki.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.fiszki.models.User;
import pl.fiszki.models.UserRole;
import pl.fiszki.models.UserStatus;
import pl.fiszki.service.UserRoleService;
import pl.fiszki.service.UserService;

import java.util.List;

/**
 * Created by Bartek on 18.04.2017.
 */

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "admin/start";
    }

    @RequestMapping(value = "adduser", method = RequestMethod.GET)
    public String addUserSite(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "admin/addUser/adduser";
    }

    /** TO DO add validate for params**/
    @RequestMapping(value = "adduser", method = RequestMethod.POST)
    public String addUserPost(Model model,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {

        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(userService.isUserInDatebase(username));
        if (userService.isUserInDatebase(username) == null) {
            /**create new user**/
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setStatus(UserStatus.ACTIVE);
            userService.addUser(user);

            /**
             * add roles for new user
             * get id from newly created user and set role = 1 // ROLE_USER
             **/
            UserRole userRole = new UserRole();
            userRole.setIdUserRole(2);
            userRole.setUserId(userService.getIdUserByUsername(username));
            userRoleService.addRolesUser(userRole);

            model.addAttribute("messageSucc", "Stworzono nowego użytkownika " + username);
        } else {
            model.addAttribute("messageErr", "Nie udało się utworzyć użytkownika " + username);
        }
        return "admin/addUser/adduser";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String deleteUserSite(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());

        model.addAttribute("userlist", userService.getListOfUsers());

        return "admin/deleteUser/deleteuser";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteUserPost(Model model,
                                 @PathVariable long id) {

        User user = userService.getUserById(id);

        if(user == null){
            model.addAttribute("message", "Err");
        }else{
            userRoleService.deleteRolesUser(id);
            userService.deleteUser(id);
            model.addAttribute("message", "Użytkownik został pomyślnie usunięty");
        }
        return "admin/deleteUser/deleteuser";
    }
}