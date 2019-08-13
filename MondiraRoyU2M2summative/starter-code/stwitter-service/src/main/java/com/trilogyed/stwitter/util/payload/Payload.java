package com.trilogyed.stwitter.util.payload;

public class Payload {
    private int commentId;
    private int postId;
    private String comment;

    public Payload() {
    }

    public Payload(int commentId, int postId, String comment) {
        this.commentId = commentId;
        this.postId = postId;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
