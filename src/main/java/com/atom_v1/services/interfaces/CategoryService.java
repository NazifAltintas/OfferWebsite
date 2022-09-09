package com.atom_v1.services.interfaces;

import com.atom_v1.data.*;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category getCategoryByTaskId(Long id);

    List<Category> getCategoriesByLocationName(String locationName);

    List<Category> getCategoriesByCompanyName(String companyName);

    String createCategory(Category category);

    String deleteCategoryById(Long id);
}
