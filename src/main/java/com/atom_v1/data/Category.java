package com.atom_v1.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private List<MasterCompany> companies;

    public Category() {
        this("");
    }

    public Category(String categoryName) {
        this(categoryName, new ArrayList<>());
    }

    public Category(String categoryName, List<MasterCompany> companies) {
        this.categoryName = categoryName;
        this.companies = companies;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<MasterCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<MasterCompany> companies) {
        this.companies = companies;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "Category in "
                + categoryName
                + " companies: "
                + companies;
    }
}
