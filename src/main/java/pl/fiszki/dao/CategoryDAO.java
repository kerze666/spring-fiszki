package pl.fiszki.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fiszki.models.words.Category;

import java.util.List;

/**
 * Created by Bartek on 04.05.2017.
 */
@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> {

    List<Category> findByUserid(long userid);

    void deleteById(long idCat);

    @Query("select 1 from Category c where c.category = ?1 and c.userid = ?2")
    Integer isCategoryByUserId(String category, long userid);

}
