package pl.fiszki.service.impl;

import org.apache.log4j.Logger;
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


    public User findUserByUsername(String username, UserStatus userStatus) {
        return userDAO.findByUsernameAndStatus(username, userStatus);
    }

    public User findUserByUserId(long id) {
        return userDAO.findOne(id);
    }

    public boolean isUser(String username) {
        return userDAO.findFirstByUsername(username)!=null;
    }

    public List<User> findAllUsers() {
        return (List<User>) userDAO.findAll();
    }

    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userDAO.delete(id);
    }

    @Transactional
    public User updateUser(long id, User user) {
        User old = userDAO.findOne(id);
        old.setCategory(user.getCategory());
        old.setPassword(user.getPassword());
        old.setRoles(user.getRoles());
        old.setStatus(user.getStatus());
        old.setUsername(user.getUsername());
        return userDAO.save(old);
    }
}
