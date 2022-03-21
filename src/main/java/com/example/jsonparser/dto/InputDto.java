package com.example.jsonparser.dto;

import com.example.jsonparser.entity.Comment;
import com.example.jsonparser.util.ParseUtil;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class InputDto {

    private String id;

    @SerializedName(value = "parent_id")
    private String parentId;

    @SerializedName(value = "link_id")
    private String linkId;

    private String name;

    private String author;

    private String body;

    @SerializedName(value = "subreddit_id")
    private String subredditId;

    private String subreddit;

    private Long score;

    @SerializedName(value = "created_utc")
    private String createdUtc;


    public Comment toCommentEntity() {
        Comment result = new Comment();
        result.setId(ParseUtil.parseTo36(id));
        result.setParentId(parentId);
        result.setLinkId(linkId);
        result.setName(name);
        result.setAuthor(author);
        result.setBody(body);
        result.setSubredditId(subredditId);
        result.setScore(score);
        result.setCreatedUtc(LocalDateTime.ofEpochSecond(Long.parseLong(createdUtc), 0, ZoneOffset.UTC));

        return result;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(String createdUtc) {
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
                ", subreddit='" + subreddit + '\'' +
                ", score=" + score +
                ", createdUtc=" + createdUtc +
                '}';
    }
}
