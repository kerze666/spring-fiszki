package pl.fiszki.service;

import org.springframework.stereotype.Repository;
import pl.fiszki.models.User;

/**
 * Created by Bartek on 17.04.2017.
 */

public interface UserService {

    public User getUserByUserNameAndStatus(String username);
}
