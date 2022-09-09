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

    @Column
    private String name;

    @Column
    private Double maxBudget;

    @Column
    private String details;

    @Column
    private Date timeStamp;

    @Column
    private String photoLinks;

    @Column
    private Date dateRangeEarliest;

    @Column
    private Date dateRangeLatest;

    @Column
    private Boolean acceptOffer;

    String errMsg;

    @JoinTable(name = "tasks_user",
            joinColumns = {@JoinColumn(name = "task_ID")},
            inverseJoinColumns = {@JoinColumn(name = "user_ID")})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User userDetails;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Offer> offers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Location location;


    public Task() {
        this.errMsg = "invalid task";
    }

    public Task(String name, Double maxBudget, String details, Date dateRangeEarliest, Date dateRangeLatest) {
        this.name = name;
        this.maxBudget = maxBudget;
        this.details = details;
        this.dateRangeEarliest = dateRangeEarliest;
        this.dateRangeLatest = dateRangeLatest;
        this.errMsg = "task is created successfully";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMaxBudget() {
        return maxBudget;
    }

    public void setMaxBudget(Double maxBudget) {
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

    public String getPhotoLinks() {
        return photoLinks;
    }

    public void setPhotoLinks(String photoLinks) {
        this.photoLinks = photoLinks;
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

    public Boolean getAcceptOffer() {
        return acceptOffer;
    }

    public void setAcceptOffer(Boolean acceptOffer) {
        this.acceptOffer = acceptOffer;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
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

    public String getErrMsg() {
        return errMsg;
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
                " task: " + name +
                " from " + userDetails;
    }
}
