package com.trilogyed.stwitter.util.feign;
import com.trilogyed.stwitter.dao.PostDao;
import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="post-service")
public interface PostServiceClient {
    @RequestMapping(value="/posts/{postId}",method= RequestMethod.GET)
    public Post getPostByPostId(@PathVariable int postId);

    @RequestMapping(value="/posts/{posterName}",method= RequestMethod.GET)
    public List<Post> getPostByPosterName(@PathVariable String posterName);
}

