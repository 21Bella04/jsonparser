package com.example.jsonparser.entity;

import javax.persistence.*;

@Entity
@Table(name = "subreddit", schema = "redditos")
public class Subreddit {

    @Id
    @Column(columnDefinition="VARCHAR(255)")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    public Subreddit() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Redit{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}