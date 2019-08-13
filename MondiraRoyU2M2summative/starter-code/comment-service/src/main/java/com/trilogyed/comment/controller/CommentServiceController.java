package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import com.trilogyed.comment.model.CommentViewModel;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = {"comments"})
public class CommentServiceController {
    @Autowired
    CommentDao dao;

    public CommentServiceController(CommentDao dao) {
       this.dao = dao;
    }

    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        System.out.println("CREATING COMMENT");
        return dao.createComment(comment);
    }
    @Cacheable
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Comment getComment(@PathVariable int id) {
        System.out.println("GETTING COMMENT ID = " + dao.getComment(id));
        return dao.getComment(id);
    }
    @Cacheable
    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments() {
        System.out.println("GETTING ALL COMMENTS");
        return dao.getAllComments();
    }
    @Cacheable
    @RequestMapping(value = "/comments/{postId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        System.out.println("GETTING POSTS BY POSTER NAME =" + postId);
        return dao.getCommentsByPostId(postId);
    }
    @CacheEvict(key = "#comment.getId()")
    @RequestMapping(value = "/comments", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateComment(@RequestBody Comment comment) {
        System.out.println("UPDATING COMMENTS = " + comment.getCommentId());
        dao.updateComment(comment);
    }

    @CacheEvict
    @RequestMapping(value = "/comments/{commentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable int commentId) {
        System.out.println("DELETING WITH COMMENT ID = " + commentId );
        dao.deleteComment(commentId);
    }
}
