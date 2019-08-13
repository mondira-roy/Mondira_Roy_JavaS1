package com.trilogyed.stwitter.util.feign;
import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name="Comment-service")
public interface CommentServiceClient {
    @RequestMapping(value="/comments/post/{postId}",method= RequestMethod.GET)
  public List<Comment> getCommentByPostId(@PathVariable int postId);

}



