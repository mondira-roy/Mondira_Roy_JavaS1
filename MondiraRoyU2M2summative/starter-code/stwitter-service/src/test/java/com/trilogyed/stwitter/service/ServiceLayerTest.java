package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.PostViewModel;
import com.trilogyed.stwitter.util.feign.CommentServiceClient;
import com.trilogyed.stwitter.util.feign.PostServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {
    @InjectMocks
    ServiceLayer serviceLayer;
    @Mock
    PostServiceClient postServiceClient;
    @Mock
    CommentServiceClient commentServiceClient;
    @Mock
    RabbitTemplate rabbitTemplate;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        setUpPostServiceClientMock();
        setUpCommentServiceClientMock();
        setUpRabbitTemplateMock();
    }

    private void setUpPostServiceClientMock() {
        // postServiceClient = mock(PostServiceClient.class);
        Post post1 = new Post();
        post1.setPostId(11);
        post1.setPosterName("Aditya");
        post1.setPostDate(LocalDate.of(2018, 10, 10));
        post1.setPostContent("this is fantastic");

        Post post2 = new Post();
        post2.setPostId(12);
        post2.setPosterName("Adarsh");
        post2.setPostDate(LocalDate.of(2015, 11, 11));
        post2.setPostContent("this is Super");

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);

        doReturn(post1).when(postServiceClient).getPostByPostId(11);
        doReturn(posts).when(postServiceClient).getPostByPosterName("Adarsh");
    }

    private void setUpCommentServiceClientMock() {
        // commentServiceClient = mock(CommentServiceClient.class);
        Comment comment = new Comment();
        comment.setCommentId(11);
        comment.setCommenterName("Aditya");
        comment.setCommentDate(LocalDate.of(2018, 10, 10));
        comment.setCommentContent("Awesome");

        Comment comment2 = new Comment();
        comment2.setPostId(11);
        comment2.setCommentContent("Great post");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        doReturn(comments).when(commentServiceClient).getCommentByPostId(11);

    }

    private void setUpRabbitTemplateMock() {

        RabbitTemplate rabbitTemplate = mock(RabbitTemplate.class);
    }

    @Test
    public void fetchPostById() throws Exception {
        PostViewModel post1 = new PostViewModel();
        post1.setPostId(11);
        post1.setPosterName("Aditya");
        post1.setPostDate(LocalDate.of(2018, 10, 10));
        post1.setPostContent("this is fantastic");


        post1.setComments(commentServiceClient.getCommentByPostId(11));
        // test save/create/new
        PostViewModel post2 = serviceLayer.fetchPostById(11);

        assertTrue(post1.equals(post2));
    }

    @Test
    public void fetchPostByPoster() throws Exception {
        PostViewModel post1 = new PostViewModel();
        post1.setPostId(11);
        post1.setPosterName("Aditya");
        post1.setPostDate(LocalDate.of(2018, 10, 10));
        post1.setPostContent("this is fantastic");
        post1.setComments(commentServiceClient.getCommentByPostId(11));

        List<PostViewModel> posts = serviceLayer.fetchPostByPoster("Aditya");

        assertEquals(posts.size(), 0);
    }

    @Test
    public void createNewPost() throws Exception {
        PostViewModel post1 = new PostViewModel();
        post1.setPostId(11);
        post1.setPosterName("Aditya");
        post1.setPostDate(LocalDate.of(2018, 10, 10));
        post1.setPostContent("this is fantastic");
        post1.setComments(commentServiceClient.getCommentByPostId(11));

        post1 = serviceLayer.createNewPost(post1);
    }
//        PostViewModel post2 = new PostViewModel();
//        post2.setPostId(11);
//        post2.setPosterName("Aditya");
//        post2.setPostDate(LocalDate.of(2018, 10, 10));
//        post2.setPostContent("this is fantastic");

    //      post1= serviceLayer.createNewPost(post1);
//        ArgumentCaptor<Post> postCaptor = ArgumentCaptor.forClass(Post.class);
//       verify(postServiceClient).getPostByPosterName(postCaptor.capture());
//       assertEquals(postServiceClient.getPostByPosterName(), postCaptor.getValue().getPostContent());
//    }
}