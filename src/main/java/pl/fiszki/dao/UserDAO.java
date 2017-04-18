package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.User;
import pl.fiszki.models.UserStatus;


@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query("select u from User u where u.username = ?1 and u.status = ?2" )
    User findByUsernameAndStatus(String username, UserStatus userStatus);
}
