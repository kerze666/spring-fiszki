package pl.fiszki.service;

import pl.fiszki.models.words.Category;

import java.util.List;

/**
 * Created by Bartek on 04.05.2017.
 */
public interface CategoryService {

    List<Category> getCategoriesByUserId(long id);

    boolean isCategory(String category, long userid);

    void addCategory(Category category);

    void deleteCategory(long idCat);
}
