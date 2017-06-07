package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.user.User;
import pl.fiszki.models.words.Category;

import java.util.List;

/**
 * Created by Bartek on 04.05.2017.
 */
@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> {

    List<Category> findAllByUser(User user);

    Category findByCategory(String category);

    @Query("select 1 from Category where category = ?1 and user = ?2")
    Integer findFirstByCategoryAndUser(String category, User user);
}
