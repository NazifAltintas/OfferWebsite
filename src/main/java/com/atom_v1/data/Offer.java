package com.atom_v1.data;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "task_offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private Task task;
    private MasterCompany company;
    private Double price;
    private Date dateRangeEarliest;
    private Date dateRangeLatest;
    private Date timeStamp;

    public Offer(){
        this(new Task(),new MasterCompany(),0.0,new Date(),new Date(),new Date());
    }

    public Offer(Task task, MasterCompany company, Double price, Date dateRangeEarliest, Date dateRangeLatest) {
       this(task,company,price,dateRangeEarliest,dateRangeLatest,new Date());
    }

    public Offer(Task task, MasterCompany company, Double price, Date dateRangeEarliest, Date dateRangeLatest, Date timeStamp) {
        this.task = task;
        this.company =company;
        this.price = price;
        this.dateRangeEarliest = dateRangeEarliest;
        this.dateRangeLatest = dateRangeLatest;
        this.timeStamp = timeStamp;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public MasterCompany getCompany() {
        return company;
    }

    public void setCompany(MasterCompany company) {
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
