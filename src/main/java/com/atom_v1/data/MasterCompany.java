package com.atom_v1.data;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
public class MasterCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String companyName;
    private String companyEmail;
    private String companyPhoneNumber;
    private User user;
    private List<Address> addresses;
    private String photoLink;
    private List<Category> categories;
    private List<Location> locations;
    private Double score;
    private String reference;
    private String certificates;
    private List<Comment> comments;
    private LocalDate participation;
    private Integer period;

    public MasterCompany() {
        this("", "", "", new User(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public MasterCompany(String companyName, String companyEmail, String companyPhoneNumber, User user, List<Address> addresses, List<Category> categories, List<Location> locations) {
        this(companyName, companyEmail, companyPhoneNumber, user, addresses, "", categories, locations, "", "");

    }

    public MasterCompany(String companyName, String companyEmail, String companyPhoneNumber, User user, List<Address> addresses, String photoLink, List<Category> categories, List<Location> locations, String reference, String certificates) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.user = user;
        this.addresses = addresses;
        this.photoLink = photoLink;
        this.categories = categories;
        this.locations = locations;
        this.reference = reference;
        this.certificates = certificates;
        this.period = getPeriod();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDate getParticipation() {
        return participation;
    }

    public void setParticipation(LocalDate participation) {
        this.participation = participation;
    }

    public Integer getPeriod() {
        if (this.participation == null) return 0;
        return Period.between(this.participation, LocalDate.now()).getYears();
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double calculateAverageLikeRating() {
        //to do calculating average rating*******************************************
        double averageLikeRating = 0.0;
        return averageLikeRating;
    }

    public Long getCompanyId() {
        return companyId;
    }

    @Override
    public String toString() {
        return companyName.toUpperCase()
                + '('
                + companyEmail.toLowerCase()
                + ')'
                + addresses;
    }
}
