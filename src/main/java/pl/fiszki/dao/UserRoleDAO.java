package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.UserRole;
import sun.awt.image.ImageWatched;

import java.util.List;


@Repository
public interface UserRoleDAO extends CrudRepository<UserRole, Long> {

    @Query("select u from User u where u.id= ?1")
    List<UserRole> findAllByUserId(long id);

    void deleteByUserId(long id);

    long getUserRoleByUserId(long userid);
}
