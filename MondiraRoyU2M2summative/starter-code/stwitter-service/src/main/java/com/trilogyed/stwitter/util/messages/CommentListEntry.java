package com.trilogyed.stwitter.util.messages;

import java.time.LocalDate;

public class CommentListEntry {
    private int commentId;
    private int postId;
    private String commenterName;
    private LocalDate commentDate;
    private String comment;

    public CommentListEntry(int commentId, int postId, String
            commenterName, LocalDate commentDate, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.commenterName = commenterName;
        this.commentDate = commentDate;
        this.comment = comment;
    }
    //Default constructor


    public CommentListEntry() {
    }

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
    public String toString() {
        return "CommentListEntry{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", commenterName='" + commenterName + '\'' +
                ", commentDate=" + commentDate +
                ", Comment='" + comment + '\'' +
                '}';
    }
}
