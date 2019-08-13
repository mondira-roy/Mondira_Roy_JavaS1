package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import com.trilogyed.stwitter.util.payload.Payload;


import javassist.NotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {
    public static final String EXCHANGE = "Comment-exchange";
    public static final String ROUTING_KEY = "Comment.create.#";
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private  PostServiceClient postServiceClient;
    @Autowired
    private  CommentServiceClient commentServiceClient;

    public ServiceLayer(RabbitTemplate rabbitTemplate,
                        PostServiceClient postServiceClient,
                        CommentServiceClient commentServiceClient) {
        this.rabbitTemplate = rabbitTemplate;
        this.postServiceClient = postServiceClient;
        this.commentServiceClient = commentServiceClient;
    }
    // get post by Id

    public PostViewModel fetchPostById(int id) throws NotFoundException {

        Post post =postServiceClient.getPostByPostId(id);
       // post.getPostId(int postId);
        PostViewModel pvm = buildPostViewModel(post);
        return pvm;
    }

    //get Post By poster
    public List<PostViewModel> fetchPostByPoster(String PosterName){
        List<Post> posts =postServiceClient.getPostByPosterName(PosterName);
        List<PostViewModel> pvms = new ArrayList<>();
            posts.stream().forEach(post -> {
                try {
                    PostViewModel tempPvm=  buildPostViewModel(post);
                    pvms.add(tempPvm);
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            });
  return pvms;
    }

    // helper method for converting  Post to PostViewModel
    private PostViewModel buildPostViewModel(Post post) throws NotFoundException {
        PostViewModel pvm = new PostViewModel();
        pvm.setPostId(post.getPostId());
        pvm.setPosterName(post.getPosterName());
        pvm.setPostDate(post.getPostDate());
        pvm.setPostContent(post.getPostContent());
        pvm.setComments(commentServiceClient.getCommentByPostId(post.getPostId()));
        return pvm;

        }

    // create post
    @Transactional
    public PostViewModel createNewPost(PostViewModel pvm)throws Exception {
        Post post = new Post();
        pvm.setPosterName(post.getPosterName());
        pvm.setPostDate(post.getPostDate());
        pvm.setPostContent(post.getPostContent());

        int id = post.getPostId();
        // save comment through queue
        List<Comment> comments = pvm.getComments();
        comments.stream().forEach(comment -> {
            comment.setPostId(id);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, comment);
        });
        try {
            pvm = buildPostViewModel(post);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return pvm;
    }




//    // delete post by Id
//    public void deletePost(int id) {
//        postDao.deletePost(id);
////delete post should delete the corresponding comments
// // get the comment list and delete it.
//            List<Comment> comments = buildPostViewModel(post).getComments();
//            comments.stream().forEach(comment -> {
//                        if (comment.getPostId() == 0) {
//                            comment.setPostId(id);
//                        }
//             commentDao.deleteComment(int postId);
//    }

//    // update post
//    @Transactional
//    public void updatePost(PostViewModel pvm) {
//        // update the book DB
//        Post post = new Post();
//        //post.setPostId(pvm.getPostId());
//        post.setPosterName(pvm.getPosterName());
//        post.setPostDate(pvm.getPostDate());
//        post.setPostContent(pvm.getPostContent());
//        postDao.updatePost(post);
//        int postId = pvm.getPostId();
//        // update comment through queue
//
//
//        List<Comment> comments = buildPostViewModel(post).getComments();
//        comments.stream().forEach(comment -> {
//            if (comment.getPostId() == 0) {
//                comment.setPostId(id);
//            }
//            Payload payload = new Payload(comment.getCommentId(), comment.getPostId(), comment.getCommentContent());
//            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, payload);
//        });

    }


