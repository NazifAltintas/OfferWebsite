package com.atom_v1.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String photoLink;
    private List<Address> addresses;

    public User() {

        this("", "", "");
    }

    public User(String email, String password, String userName) {
        this(email, password, userName, "", "");
    }

    public User(String email, String password, String userName, String firstName, String lastName) {
        this(email, password, userName, firstName, lastName, "", "", new ArrayList<>());
    }

    public User(String email, String password, String userName, String firstName, String lastName, String phoneNumber, String photo, List<Address> addresses) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.photoLink = photo;
        this.addresses = addresses;
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
