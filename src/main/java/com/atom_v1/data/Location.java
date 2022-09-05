package com.atom_v1.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    private String locationName;
    private List<MasterCompany> companies;

    public Location() {
        this("");
    }

    public Location(String locationName) {
        this(locationName, new ArrayList<>());
    }

    public Location(String locationName, List<MasterCompany> companies) {
        this.locationName = locationName;
        this.companies = companies;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<MasterCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<MasterCompany> companies) {
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
