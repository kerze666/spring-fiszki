package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.user.User;
import pl.fiszki.models.user.UserStatus;


@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    User findByUsernameAndStatus(String username, UserStatus userStatus);

    @Query("select 1 from User where username = ?1")
    Integer findFirstByUsername( String username);
}