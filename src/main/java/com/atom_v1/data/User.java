package com.atom_v1.data;

import javax.persistence.*;
import java.util.List;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    @Column(length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 45)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String phoneNumber;

    @Column()
    private String photoLink;

    String errMsg;

    @JoinTable(name = "user_addresses",
            joinColumns = {@JoinColumn(name = "user_ID")},
            inverseJoinColumns = {@JoinColumn(name = "address_ID")})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Company masterCompany;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Task> tasks;


    public User() {

        this.errMsg = "invalid user";
    }

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.errMsg = "user is created successfully";
    }

    public User(String email, String password, String userName, String firstName, String lastName, String phoneNumber, String photoLink) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.photoLink = photoLink;
        this.errMsg = "user is created successfully";
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Company getMasterCompany() {
        return masterCompany;
    }

    public void setMasterCompany(Company masterCompany) {
        this.masterCompany = masterCompany;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoto() {
        return photoLink;
    }

    public void setPhoto(String photo) {
        this.photoLink = photo;
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

    @Override
    public String toString() {
        return firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase()
                + " "
                + lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase()
                + "("
                + email.toLowerCase()
                + ")";

    }
}
