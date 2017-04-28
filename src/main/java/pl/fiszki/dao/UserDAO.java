package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.User;
import pl.fiszki.models.UserStatus;

import java.util.List;


@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query("select u from User u where u.username = ?1 and u.status = ?2")
    User findByUsernameAndStatus(String username, UserStatus userStatus);

    @Query("select u from User u")
    List<User> getAllUsers();

    @Query("select u.id from User u where u.username = ?1")
    long getIdByUsername(String username);

    @Query("select 1 from User u where u.username = ?1")
    Integer isUser(String username);

    User findById(long id);
}