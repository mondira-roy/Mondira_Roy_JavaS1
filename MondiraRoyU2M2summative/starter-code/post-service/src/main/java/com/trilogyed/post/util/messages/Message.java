package com.trilogyed.post.util.messages;

import java.util.Objects;

public class Message {

    private int postId;
    private String post;
    private String comment;

    public Message() {
    }

    public Message(int postId, String post, String comment) {
        this.postId = postId;
        this.post = post;
        this.comment = comment;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
        Message message = (Message) o;
        return postId == message.postId &&
                post.equals(message.post) &&
                comment.equals(message.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, post, comment);
    }
}
