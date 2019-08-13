package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringBootTest
    public class PostDaoJdbcTemplateImplTest {
        @Autowired
        PostDao dao;

        @Before
        public void setUp() throws Exception {
            List<Post> posts = dao.getAllPosts();
            for (Post post : posts) {
                dao.deletePost(post.getPostId());
            }
        }
        @Test
        public void createGetDeletePost(){
            Post post = new Post();

            post.setPostDate(LocalDate.of(2018,11,11));
            post.setPosterName("Name1");
            post.setPost("post1");

            post = dao.createPost(post);

            Post post1 = dao.getPost(post.getPostId());
            assertEquals(post1, post);

            dao.deletePost(post.getPostId());
            post1 = dao.getPost(post.getPostId());
            assertNull(post1);
        }


    @Test
    public void getPostByPosterName() {
        Post post = new Post();
        post.setPostId(1);
        post.setPostDate(LocalDate.of(2018,11,11));
        post.setPosterName("Name1");
        post.setPost("post1");

        dao.createPost(post);

        List<Post> posts = dao.getPostByPosterName("Name1");
        assertEquals(posts.size(),1);
    }

    @Test
    public void getAllPosts() {
        Post post = new Post();

        post.setPostDate(LocalDate.of(2018,11,15));
        post.setPosterName("Name1");
        post.setPost("post1");

        post = dao.createPost(post);

        post = new Post();
        post.setPostDate(LocalDate.of(2015,10,11));
        post.setPosterName("Name2");
        post.setPost("post2");

        post = dao.createPost(post);

        List<Post> pList = dao.getAllPosts();
        assertEquals(2, pList.size());
    }

    @Test
    public void updatePost() {
        Post post = new Post();
        post.setPostDate(LocalDate.of(2018,11,15));
        post.setPosterName("Name1");
        post.setPost("post1");

        post = dao.createPost(post);

        post.setPostDate(LocalDate.of(2015,10,10));
        post.setPosterName("Name2");
        post.setPost("post2");

        dao.updatePost(post);

        Post post1  = dao.createPost(post);
        assertEquals(post1,post);
    }
    }
//    @Test
//    public void createPost() {
//    }
//
//    @Test
//    public void getPost() {
//    }
//    @Test
//    public void deletePost() {
//    }
