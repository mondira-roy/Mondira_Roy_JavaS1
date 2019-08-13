package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class StwitterServiceController {


    ServiceLayer service;

    public StwitterServiceController(ServiceLayer service) {
        this.service = service;
    }


        @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public PostViewModel createPost(@RequestBody @Valid PostViewModel pvm) throws Exception {
        System.out.println("CREATING POST");
        return service.createNewPost(pvm);
    }

        @Cacheable
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PostViewModel getPostByPostId(@PathVariable int id) throws NotFoundException {
        System.out.println("GETTING POST ID = " + id);
        return service.fetchPostById(id);
    }
    @Cacheable
    @RequestMapping(value = "/posts/{posterName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PostViewModel> getPostByPosterName(@PathVariable String posterName) {
        System.out.println("GETTING POST ID = " + posterName);
        return service.fetchPostByPoster(posterName);
    }



//    @RequestMapping(value = "/posts", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<PostViewModel> getAllPosts() {
//        System.out.println("GETTING ALL POSTS");
//        return service.fetchAllPosts();
//    }

//        @CacheEvict(key = "#post.getId()")
//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public void updatePost(@RequestBody @Valid PostViewModel pvm, @PathVariable int id) throws NotFoundException {
//        System.out.println("UPDATING POST ID = " + pvm.getPostId());
//        if (id!=pvm.getPostId()){
//            throw new NotFoundException("should match ids");
//        }
//        service.updatePost(pvm);
//    }
//
//    //    @CacheEvict
//    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public void deletePost(@PathVariable int id) {
//        System.out.println("DELETING POST ID = " + id);
//        service.deletePost(id);
//    }

}
