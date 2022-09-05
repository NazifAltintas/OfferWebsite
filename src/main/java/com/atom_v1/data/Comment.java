package com.atom_v1.data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private User author;
    private MasterCompany company;
    private String content;
    private int like;
    private Date timeStamp;

    public Comment() {
        this(new User(), new MasterCompany(), "");
    }

    public Comment(User author, MasterCompany company, String content) {
        this(author, company, content, 0, new Date());
    }

    public Comment(User author, MasterCompany company, String content, int like, Date timeStamp) {
        this.author = author;
        this.company = company;
        this.content = content;
        this.like = like;
        this.timeStamp = timeStamp;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public MasterCompany getCompany() {
        return company;
    }

    public void setCompany(MasterCompany company) {
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getCommentId() {
        return commentId;
    }

    @Override
    public String toString() {
        return "Comment by "
                + author
                + " about "
                + company
                + ", \""
                + content
                + '\"'
                + " on "
                + timeStamp;
    }
}
