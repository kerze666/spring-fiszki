package pl.fiszki.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.user.UserRole;


@Repository
public interface UserRoleDAO extends CrudRepository<UserRole, Long> {

}
