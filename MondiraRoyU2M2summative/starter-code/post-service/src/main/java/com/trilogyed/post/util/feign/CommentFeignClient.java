package com.trilogyed.post.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.stream.events.Comment;
import java.util.List;

@FeignClient(name="comment-service")
public interface CommentFeignClient {

        @RequestMapping(value="/comments/post/{postId}",method= RequestMethod.GET)
        public List<Comment> getCommentByPostId(@PathVariable int postId);

        @RequestMapping(value="/comments/post/{postId}",method= RequestMethod.DELETE)
        public void deleteCommentByPostId(@PathVariable int postId);}
