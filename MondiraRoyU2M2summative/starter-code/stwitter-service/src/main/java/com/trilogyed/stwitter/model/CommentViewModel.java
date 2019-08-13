package com.trilogyed.stwitter.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

public class CommentViewModel {
    private int commentId;
    @NotNull(message = "Has to be a valid number")
    private int postId;
    @NotEmpty(message = "Need a Name")
    private String commenterName;
    @NotEmpty(message = "Need a Date")
    private LocalDate commentDate;
    @NotEmpty(message = "Need some content")
    private String commentContent;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getCommenterName() {
        return commenterName;
    }

    public void setCommenterName(String commenterName) {
        this.commenterName = commenterName;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentViewModel that = (CommentViewModel) o;
        return commentId == that.commentId &&
                postId == that.postId &&
                commenterName.equals(that.commenterName) &&
                commentDate.equals(that.commentDate) &&
                commentContent.equals(that.commentContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commenterName, commentDate, commentContent);
    }
}
