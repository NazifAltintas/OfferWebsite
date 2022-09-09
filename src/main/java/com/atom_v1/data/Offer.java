package com.atom_v1.data;


import javax.persistence.*;
import java.util.Date;
@Entity

public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @Column(nullable = false)
    private Double price;

    @Column
    private Date dateRangeEarliest;

    @Column
    private Date dateRangeLatest;

    @Column
    private Date timeStamp;

    String errMsg;

    @JoinTable(name = "offers_task",
            joinColumns = {@JoinColumn(name = "offer_ID")},
            inverseJoinColumns = {@JoinColumn(name = "task_ID")})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Task task;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Company company;


    public Offer(){
        this.errMsg = "invalid offer";
    }


    public Offer(Double price, Date dateRangeEarliest, Date dateRangeLatest) {
        this.price = price;
        this.dateRangeEarliest = dateRangeEarliest;
        this.dateRangeLatest = dateRangeLatest;
        this.errMsg = "offer is created successfully";
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Offer for: "
                + task
                + " by "
                + company.getCompanyName()
                + " with "
                + price
                + " between "
                + dateRangeEarliest
                + " and "
                + dateRangeLatest
                + " on "
                + timeStamp ;
    }

    public Long getOfferId() {
        return offerId;
    }
}
