package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.CategoryRepository;
import com.atom_v1.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public Category getCategoryByTask(Task task) {
        return null;
    }

    @Override
    public List<Category> getCategoriesByLocation(Location location) {
        return null;
    }

    @Override
    public List<Category> getCategoriesByCompany(MasterCompany company) {
        return null;
    }

    @Override
    public void createCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }
}
