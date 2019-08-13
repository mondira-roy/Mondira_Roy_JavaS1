package com.trilogyed.stwitter.util.messages;

import java.time.LocalDate;

public class PostListEntry {

    private int postId;
    private String posterName;
    private LocalDate postDate;
    private String post;

    public PostListEntry() {
    }

    public PostListEntry(int postId, String posterName, LocalDate postDate, String post) {
        this.postId = postId;
        this.posterName = posterName;
        this.postDate = postDate;
        this.post = post;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostListEntry{" +
                "postId=" + postId +
                ", posterName='" + posterName + '\'' +
                ", postDate=" + postDate +
                ", post='" + post + '\'' +
                '}';
    }
}