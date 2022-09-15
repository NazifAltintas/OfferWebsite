package com.atom_v1.services.implementations;

import com.atom_v1.data.*;
import com.atom_v1.repository.CategoryRepository;
import com.atom_v1.repository.TaskRepository;
import com.atom_v1.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private TaskRepository taskRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, TaskRepository taskRepository) {
        this.categoryRepository = categoryRepository;
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        if (categoryRepository.findById(id).isPresent()) {

            return categoryRepository.findById(id).get();
        }
        return new Category();
    }

    @Override
    public Category getCategoryByTaskId(Long id) {
        if (taskRepository.findById(id).isPresent()) {
            Task task = taskRepository.findById(id).get();
            return task.getCategory();
        }
        return new Category();
    }

    @Override
    public List<Category> getCategoriesByLocationId(Long id) {
        List<Category> categoryList, categories;
        categoryList = new ArrayList<>();
        categories = categoryRepository.findAll();
        List<Location> locations;
        for (Category category : categories) {
            locations = category.getLocations();
            for (Location location : locations)
                if (location.getLocationId()==id) {
                    categoryList.add(category);
                }
        }
        return categoryList;
    }


    @Override
    public List<Category> getCategoriesByCompanyId(Long id) {
        List<Category> categoryList, categories;
        categoryList = new ArrayList<>();
        categories = categoryRepository.findAll();
        List<Company> companies;
        for (Category category : categories) {
            companies= category.getCompanies();
            for (Company company : companies)
                if (company.getCompanyId()==id) {
                    categoryList.add(category);
                }
        }
        return categoryList;
    }


    @Override
    public String createCategory(Category category) {
        categoryRepository.save(category);
        if (categoryRepository.existsById(category.getCategoryId())) return "category is created successfully";
        return "category couldn't  be created";
    }


    @Override
    public String deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalStateException(id + " does not exist ");
        } else {
            categoryRepository.deleteById(id);
            return "Category with id is " + id + " is successfully deleted";
        }
    }


}
