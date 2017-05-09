package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.fiszki.dao.CategoryDAO;
import pl.fiszki.models.words.Category;
import pl.fiszki.service.CategoryService;

import java.util.List;

/**
 * Created by Bartek on 04.05.2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    // add all categories with default categories
    public List<Category> getCategoriesByUserId(long id) {
        List<Category> categories = categoryDAO.findByUserid(1);
        categories.addAll(categoryDAO.findByUserid(id));
        return categories;
    }

    // if category and userid is exists in database return TRUE else return FALSE
    public boolean isCategory(String category, long userid) {
        if (categoryDAO.isCategoryByUserId(category, userid) == null) {
            return false;
        }else{
            return true;
        }
    }

    public void addCategory(Category category) {
        categoryDAO.save(category);
    }

    public void deleteCategory(long idCat) {
        categoryDAO.delete(idCat);
    }


}
