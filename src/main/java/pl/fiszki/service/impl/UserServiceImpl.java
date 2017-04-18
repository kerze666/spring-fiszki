package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fiszki.dao.UserDAO;
import pl.fiszki.models.User;
import pl.fiszki.models.UserStatus;
import pl.fiszki.service.UserService;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Bartek on 17.04.2017.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    public User getUserByUserNameAndStatus(String username) {
        return userDAO.findByUsernameAndStatus(username, UserStatus.ACTIVE);
    }
}
