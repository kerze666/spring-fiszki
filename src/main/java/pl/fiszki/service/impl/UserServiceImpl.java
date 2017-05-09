package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.UserDAO;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserStatus;
import pl.fiszki.service.UserService;

import java.util.List;

/**
 * Created by Bartek on 17.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUserByUserNameAndStatus(String username) {
        return userDAO.findByUsernameAndStatus(username, UserStatus.ACTIVE);
    }

    public User getUserById(long id) {
        return userDAO.findById(id);
    }

    public long getIdUserByUsername(String username) {
        return userDAO.getIdByUsername(username);
    }

    public Integer isUserInDatebase(String username) {
        return userDAO.isUser(username);
    }

    public List<User> getListOfUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDAO.delete(id);
    }

    @Transactional
    public void editUser(long id) {
    }
}
