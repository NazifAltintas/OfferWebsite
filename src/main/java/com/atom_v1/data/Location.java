package com.atom_v1.data;


import javax.persistence.*;
import java.util.List;

@Entity

public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column
    private String locationName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Company> companies;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Category> categories;

//    @JoinTable(name = "location_tasks",
//            joinColumns = {@JoinColumn(name = "location_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "task_ID")})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Task> tasks;

    String errMsg;


    public Location() {
        this.errMsg = "invalid location name";
    }

    public Location(String locationName) {
        this.locationName = locationName;
        this.errMsg = "location is created successfully";
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Long getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return "Companies in "
                + locationName + ": "
                + companies;
    }
}
