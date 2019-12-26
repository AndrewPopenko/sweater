package com.example.sweater.domain;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
    public Message() {
    }

    public Message(String text, String tags, User user) {
        this.user = user;
        this.text = text;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUserName() {
        return user != null ? user.getUsername() : "<none>";
    }

    public String getText() {
        return text;
    }

    public String getTags() {
        return tags;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tags;
    private String filename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
