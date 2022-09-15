package com.atom_v1.data;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column
    private String companyName;

    @Column
    private String companyEmail;

    @Column
    private String details;
    @Column
    private String facebookLink;
    @Column
    private String twitterLink;
    @Column
    private String linkedinLink;
    @Column
    private String instagramLink;
    @Column
    private String youtubeLink;


    @Column
    private String companyPhoneNumber;

    @Column
    private String reference;

    @Column
    private String certificates;

    @Column
    private static Double score;


    @Column
    private String photoLink;

    @Column
    private LocalDate participation;

    @Column
    private Integer cperiod;

    String errMsg;

//    @JoinTable(name = "company_user",
//            joinColumns = {@JoinColumn(name = "company_ID")},
//
//            inverseJoinColumns = {@JoinColumn(name = "user_ID")})
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

//    @JoinTable(name = "company_addresses",
//            joinColumns = {@JoinColumn(name = "company_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "address_ID")})
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @JoinTable(name = "categories_company")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> categories;

    @JoinTable(name = "company_locations",
            joinColumns = {@JoinColumn(name = "company_ID")},
            inverseJoinColumns = {@JoinColumn(name = "location_ID")})

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

//    @JoinTable(name = "company_offers",
//            joinColumns = {@JoinColumn(name = "company_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "offer_ID")})
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Offer> offers;


    public Company() {
        this.errMsg = "invalid company creation";
        this.cperiod = getCperiod();

    }

    public Company(String companyName, String companyEmail, String companyPhoneNumber, List<Address> addresses) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhoneNumber = companyPhoneNumber;
        this.addresses = addresses;
        this.cperiod = getCperiod();
        this.errMsg = "company is created successfully";
    }

    public Integer getCperiod() {
        if (this.participation == null) return 0;
        return Period.between(this.participation, LocalDate.now()).getYears();
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCompanyId() {
        return companyId;
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

    public Double getScore() {


        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public LocalDate getParticipation() {
        return participation;
    }

    public void setParticipation(LocalDate participation) {
        this.participation = participation;
    }

    public void setCperiod(Integer period) {
        this.cperiod = period;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }


    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
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
