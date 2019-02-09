package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    public Message() {
    }

    public Message(String text, String tags) {
        this.text = text;
        this.tags = tags;
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

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tags;
}
