package pl.fiszki.service;

import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserStatus;

import java.util.List;

/**
 * Created by Bartek on 17.04.2017.
 */

public interface UserService {

    User findUserByUsername(String username, UserStatus userStatus);

    User findUserByUserId(long id);

    boolean isUser(String username);

    List<User> findAllUsers();

    User createUser(User user);

    void deleteUser(long id);

    User updateUser(long id, User user);

}
