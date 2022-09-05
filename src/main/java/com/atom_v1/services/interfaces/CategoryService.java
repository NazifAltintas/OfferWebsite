package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category getCategoryByTask(Task task);

    List<Category> getCategoriesByLocation(Location location);

    List<Category> getCategoriesByCompany(MasterCompany company);

    void createCategory(Category category);

    void deleteCategory(Category category);
}
