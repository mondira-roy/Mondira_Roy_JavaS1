package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
import com.trilogyed.post.util.feign.CommentFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@CacheConfig(cacheNames = "posts")
public class PostServiceController {
    @Autowired
    PostDao dao;

    @Autowired
    private final CommentFeignClient client;

    public PostServiceController(PostDao dao, CommentFeignClient client) {
        this.dao = dao;
        this.client = client;
    }

    @CachePut(key = "#result.getPostId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        System.out.println("CREATING POST");
        return dao.createPost(post);
    }
    @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        System.out.println("GETTING POST ID = " + id);
        return dao.getPost(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getAllPosts() {
        System.out.println("GETTING ALL POSTS");
        return dao.getAllPosts();
    }
    @Cacheable
    @RequestMapping(value = "/posts/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Post> getPostByPosterName(@PathVariable String name) {
        System.out.println("GETTING POSTS BY POSTER NAME =" + name);
        return dao.getPostByPosterName(name);
    }

    @CacheEvict(key = "#post.getPostId()")
    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@RequestBody Post post) {
    System.out.println("UPDATING POSTS = " + post.getPostId());
    dao.updatePost(post);
    }

    @CacheEvict
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable int id) {
        System.out.println("DELETING POST ID = " + id   );
        dao.deletePost(id);
        client.deleteCommentByPostId(id);   //This takes care of referential integrity
    }
}
