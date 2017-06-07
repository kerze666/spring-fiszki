package pl.fiszki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fiszki.dao.CategoryDAO;
import pl.fiszki.models.user.User;
import pl.fiszki.models.words.Category;
import pl.fiszki.service.CategoryService;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public Category findCategoryById(long idcat) {
        return categoryDAO.findOne(idcat);
    }

    // add all categories with default categories
    public List<Category> findCategoriesByUser(User user) {
        return categoryDAO.findAllByUser(user);
    }

    // if category and userid is exists in database return TRUE else return FALSE
    public boolean isCategory(String category, User user) {
        return categoryDAO.findFirstByCategoryAndUser(category, user)!=null;
    }

    public void addCategory(Category category) {
        categoryDAO.save(category);
    }

    public void deleteCategory(long idCat) {
        categoryDAO.delete(idCat);
    }


}
