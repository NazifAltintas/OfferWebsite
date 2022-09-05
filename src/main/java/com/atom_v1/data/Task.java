package com.atom_v1.data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private Category category;
    private Location location;
    private List<String> photoLinks;
    private double maxBudget;
    private String details;
    private Date timeStamp;
    private Date dateRangeEarliest;
    private Date dateRangeLatest;
    private User userDetails;
    private List<Offer> offers;
    private boolean acceptOffer;

    public Task() {
        this(new Category(), new Location(), 0.0, new Date(), new Date(), new Date(), new User());
    }

    public Task(Category category, Location location, double maxBudget, Date timeStamp, Date dateRangeEarliest, Date dateRangeLatest, User userDetails) {
        this(category, location, new ArrayList<>(), maxBudget, "", timeStamp, dateRangeEarliest, dateRangeLatest, userDetails);
    }

    public Task(Category category, Location location, List<String> photoLinks, double maxBudget, String details, Date timeStamp, Date dateRangeEarliest, Date dateRangeLatest, User userDetails) {
        this.category = category;
        this.location = location;
        this.photoLinks = photoLinks;
        this.maxBudget = maxBudget;
        this.details = details;
        this.timeStamp = timeStamp;
        this.dateRangeEarliest = dateRangeEarliest;
        this.dateRangeLatest = dateRangeLatest;
        this.userDetails = userDetails;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getPhotoLinks() {
        return photoLinks;
    }

    public void setPhotoLinks(List<String> photoLinks) {
        this.photoLinks = photoLinks;
    }

    public double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getDateRangeEarliest() {
        return dateRangeEarliest;
    }

    public void setDateRangeEarliest(Date dateRangeEarliest) {
        this.dateRangeEarliest = dateRangeEarliest;
    }

    public Date getDateRangeLatest() {
        return dateRangeLatest;
    }

    public void setDateRangeLatest(Date dateRangeLatest) {
        this.dateRangeLatest = dateRangeLatest;
    }

    public User getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public boolean isAcceptOffer() {
        return acceptOffer;
    }

    public void setAcceptOffer(boolean acceptOffer) {
        this.acceptOffer = acceptOffer;
    }

    public Long getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return category +
                " in " + location +
                " between " + dateRangeEarliest +
                " and " + dateRangeLatest +
                " from " + userDetails;
    }
}
