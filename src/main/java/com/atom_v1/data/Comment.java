package com.atom_v1.data;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    private String content;

    @Column
    private Integer like;

    @Column
    private String authorEmail;

    @Column
    private String authorUserName;

    @Column
    private LocalDate timeStamp;

    String errMsg;

//    @JoinTable(name = "comments_user",
//            joinColumns = {@JoinColumn(name = "comment_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "user_ID")})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;

//    @JoinTable(name = "comments_company",
//            joinColumns = {@JoinColumn(name = "comment_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "company_ID")})
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Company company;

    public Comment() {
        this.timeStamp=getTimeStamp();
        this.errMsg = "invalid comment";
    }

    public Comment(String content) {
        this.content = content;
        this.errMsg = "comment is created successfully";
    }

    public Comment(String content, int like) {
        this.content = content;
        this.like = like;
        this.errMsg = "comment is created successfully";
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthorUserName() {
        return authorUserName;
    }

    public void setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User author) {
        this.user = author;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public LocalDate getTimeStamp() {
        return LocalDate.now();
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getCommentId() {
        return commentId;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "Comment by "
                + user
                + " about "
                + company
                + ", \""
                + content
                + '\"'
                + " on "
                + timeStamp;
    }
}
