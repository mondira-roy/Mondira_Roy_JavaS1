package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PostViewModel {
    private int postId;
    @NotEmpty(message = "Need a Name")
    private String posterName;
    @NotEmpty(message = "Need a Date")
    private LocalDate postDate;
    @NotEmpty(message = "Need some content")
    private String postContent;
    @NotEmpty(message = "Pls provide atleast an empty array")
    private List<Comment> comments;

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

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostViewModel that = (PostViewModel) o;
        return postId == that.postId &&
                posterName.equals(that.posterName) &&
                postDate.equals(that.postDate) &&
                postContent.equals(that.postContent) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, posterName, postDate, postContent, comments);
    }
}