//package com.trilogyed.post.service;
//
//import com.trilogyed.post.dao.PostDao;
//import com.trilogyed.post.model.Post;
//import com.trilogyed.post.model.PostViewModel;
//import com.trilogyed.post.util.feign.CommentFeignClient;
//import javassist.NotFoundException;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.net.SocketTimeoutException;
//import java.util.List;
//
//@Component
//public class PostServiceLayer {
//
//    public static final String EXCHANGE = "comment-exchange";
//    public static final String ROUTING_KEY = "comment.create.#";
//
//    @Autowired
//    PostDao postDao;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private CommentFeignClient client;
//
//    public PostServiceLayer(CommentFeignClient client, PostDao postDao, RabbitTemplate rabbitTemplate) {
//        this.client = client;
//        this.postDao = postDao;
//        this.rabbitTemplate = rabbitTemplate;
//    }
//
//    @Transactional
//    public PostViewModel fetchBook(int id) {
//
//        Post post = postDao.getPost(id);
//        PostViewModel pvm = buildPostViewModel(post);
//        return pvm;
//    }
//    private PostViewModel buildPostViewModel(Post post) {
//        PostViewModel pvm = new PostViewModel();
//        pvm.setPostId(post.getPostId());
//        pvm.setPostDate(post.getPostDate());
//        pvm.setPosterName(post.getPosterName());
//        pvm.setPost(post.getPost());
//
//        try {
//            // Your code that throws SocketTimeoutException
//            List<Comments> posts = client.getCommentByPostId(post.getPostId());
//            pvm.setComment(posts);
//        } catch (Exception e) {
//            if (e.getCause().getClass().equals(SocketTimeoutException.class)) {
//                throw new NotFoundException("server connection timeout!");
//                // Do handling for socket exception
//            } else {
//                throw e;
//            }
//        }
//}
