package pl.fiszki.service;

import org.springframework.stereotype.Repository;
import pl.fiszki.models.User;
import pl.fiszki.models.UserRole;

import java.util.List;

/**
 * Created by Bartek on 17.04.2017.
 */

public interface UserService {

    User getUserByUserNameAndStatus(String username);
    User getUserById(long id);
    long getIdUserByUsername(String username);
    Integer isUserInDatebase(String username);
    List<User> getListOfUsers();
    void addUser(User user);
    void deleteUser(long id);
    void editUser(long id);

}
