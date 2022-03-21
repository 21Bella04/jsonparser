package com.example.jsonparser.entity;

import javax.persistence.*;

@Entity
@Table(name = "link", schema = "redditos")
public class Link {

    @Id
    @Column(columnDefinition="VARCHAR(255)")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "subreddit_fk", columnDefinition="VARCHAR(255)")
    private String subredditFk;

    public Link() {
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

    public String getSubredditFk() {
        return subredditFk;
    }

    public void setSubredditFk(String subredditFk) {
        this.subredditFk = subredditFk;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subredditFk='" + subredditFk + '\'' +
                '}';
    }
}