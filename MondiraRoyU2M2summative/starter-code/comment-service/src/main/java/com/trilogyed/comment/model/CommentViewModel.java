package com.trilogyed.comment.model;

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
    private String comment;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
                comment.equals(that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, commenterName, commentDate, comment);
    }
}
