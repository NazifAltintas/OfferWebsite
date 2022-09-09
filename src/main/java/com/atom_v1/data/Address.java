package com.atom_v1.data;

import javax.persistence.*;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String street;

    @Column(nullable = false, length = 4)
    private Integer houseNr;

    @Column(nullable = false, length = 4)
    private Integer box;

    @Column(nullable = false, length = 4)
    private Integer ZIP;

    @Column(nullable = false, length = 15)
    private String city;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Company company;

    private String errMsg;

    public Address() {
        this.errMsg = "invalid address";
    }

    public Address(String street, Integer houseNr, Integer ZIP, String city) {

        this.street = street;
        this.houseNr = houseNr;
        this.ZIP = ZIP;
        this.city = city;
        this.errMsg = "address is created successfully";

    }

    public Address(String street, Integer houseNr, Integer box, Integer ZIP, String city) {
        this.street = street;
        this.houseNr = houseNr;
        this.box = box;
        this.ZIP = ZIP;
        this.city = city;
        this.errMsg = "address is created successfully";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(Integer houseNr) {
        this.houseNr = houseNr;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public Integer getZIP() {
        return ZIP;
    }

    public void setZIP(Integer ZIP) {
        this.ZIP = ZIP;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return street.substring(0, 1).toUpperCase() + street.substring(1).toLowerCase() + ' ' +
                houseNr +
                "\\" + box +
                ", " + ZIP +
                " " + city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
    }
}
