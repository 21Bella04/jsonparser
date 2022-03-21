package com.example.jsonparser.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment", schema = "redditos")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "link_fk")
    private String linkId;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @Column(name = "subreddit_id", columnDefinition="VARCHAR(255)")
    private String subredditId;

    @Column(name = "score")
    private Long score;

    @Column(name = "created_utc")
    private LocalDateTime createdUtc;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public LocalDateTime getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(LocalDateTime createdUtc) {
        this.createdUtc = createdUtc;
    }

    @Override
    public String toString() {
        return "Redit{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", linkId=" + linkId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", body='" + body + '\'' +
                ", subredditId=" + subredditId +
                ", score=" + score +
                ", createdUtc=" + createdUtc +
                '}';
    }
}