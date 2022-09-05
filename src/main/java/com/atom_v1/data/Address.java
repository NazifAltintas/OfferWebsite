package com.atom_v1.data;

import javax.persistence.*;


@Entity
@Table(name = "user_addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String street;
    private int houseNr;
    private int bus;
    private int ZIP;
    private String city;
    private User user;
    private MasterCompany company;
    private String errMsg;

    public Address() {
        this("",-1,-1,"",null);
        this.errMsg="invalid address";
    }

    public Address(String street, int houseNr, int ZIP, String city, User user) {
        this(street,houseNr,0,ZIP,city,user);


    }

    public Address(String street, int houseNr, int ZIP, String city, User user, MasterCompany company) {
        this(street,houseNr,0,ZIP,city,user,company);

    }

    public Address(String street, int houseNr, int bus, int ZIP, String city, User user) {
        this.street = street;
        this.houseNr = houseNr;
        this.bus = bus;
        this.ZIP = ZIP;
        this.city = city;
        this.user = user;
        this.errMsg="address is created successfully";
    }

    public Address(String street, int houseNr, int bus, int ZIP, String city, User user, MasterCompany company) {
        this.street = street;
        this.houseNr = houseNr;
        this.bus = bus;
        this.ZIP = ZIP;
        this.city = city;
        this.user = user;
        this.company = company;
        this.errMsg="address is created successfully";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
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

    public MasterCompany getCompany() {
        return company;
    }

    public void setCompany(MasterCompany company) {
        this.company = company;
    }

    public Long getAddressId() {
        return addressId;
    }

    @Override
    public String toString() {
        return   street.substring(0,1).toUpperCase()+street.substring(1).toLowerCase() + ' ' +
                houseNr +
                "\\" + bus +
                ", " + ZIP +
                " " + city.substring(0,1).toUpperCase()+city.substring(1).toLowerCase();
    }
}
