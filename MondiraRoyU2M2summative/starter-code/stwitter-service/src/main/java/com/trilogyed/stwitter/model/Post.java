package com.trilogyed.stwitter.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Post {
    private int postId;
    private  String postContent;
    private LocalDate postDate;
    private String posterName;
    private List<String> comments;

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getPosterName() {
        return posterName;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post that = (Post) o;
        return postId == that.postId &&
                postContent.equals(that.postContent) &&
                postDate.equals(that.postDate) &&
                posterName.equals(that.posterName) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, postContent, postDate, posterName, comments);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postContent='" + postContent + '\'' +
                ", postDate=" + postDate +
                ", posterName='" + posterName + '\'' +
                ", comments=" + comments +
                '}';
    }
}
