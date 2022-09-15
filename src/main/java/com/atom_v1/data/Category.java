package com.atom_v1.data;


import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    private String categoryName;

    @Column
    String photoLink;

    @JoinTable(name = "categories_company",
            joinColumns = {@JoinColumn(name = "category_ID")},
            inverseJoinColumns = {@JoinColumn(name = "company_ID")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Company> companies;

//    @JoinTable(name = "category_tasks",
//            joinColumns = {@JoinColumn(name = "category_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "task_ID")})
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    @JoinTable(name = "categories_locations",
         joinColumns = {@JoinColumn(name = "category_ID")},
           inverseJoinColumns = {@JoinColumn(name = "location_ID")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Location> locations;

    private String errMsg;

    public Category() {
        this.errMsg = "invalid category name";
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.errMsg = "category is created successfully";
    }

    public List<Task> getTask() {
        return tasks;
    }

    public void setTask(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    @Override
    public String toString() {
        return "Category in "
                + categoryName
                + " companies: "
                + companies;
    }
}
