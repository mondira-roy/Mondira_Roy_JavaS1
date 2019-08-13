package com.trilogyed.stwitter.dao;

import com.trilogyed.stwitter.model.Comment;

import java.util.List;

public interface CommentDao {

        public Comment createComment(Comment comment);

        public Comment getComment(int id);

        public List<Comment> getCommentByPostId(int id);

        public List<Comment> getAllComments();

        public void updateComment(Comment comment);

        public void deleteComment(int id);
    }

