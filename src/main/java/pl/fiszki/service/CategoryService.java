package pl.fiszki.service;

import pl.fiszki.models.user.User;
import pl.fiszki.models.words.Category;

import java.util.List;

/**
 * Created by Bartek on 04.05.2017.
 */
public interface CategoryService {

    Category findCategoryById(long idcat);

    List<Category> findCategoriesByUser(User user);

    boolean isCategory(String category, User user);

    void addCategory(Category category);

    void deleteCategory(long idCat);
}
