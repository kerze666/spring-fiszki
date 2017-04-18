package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.UserRole;

import java.util.List;


@Repository
public interface UserRoleDAO extends CrudRepository<UserRole, Long> {

}
