package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
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
    public class CommentDaoJdbcTemplateImplTest {
        @Autowired
        CommentDao dao;

        @Before
        public void setUp() throws Exception {
            List<Comment> comments = dao.getAllComments();

            comments.stream()
                    .forEach(comment -> dao.deleteComment(comment.getCommentId()));
            }

        @Test
        public void createGetDeleteComment(){
            Comment comment = new Comment();

            comment.setPostId(1);
            comment.setCreateDate(LocalDate.of(2018,11,11));
            comment.setCommenterName("Name1");
            comment.setComment("comment1");

            comment = dao.createComment(comment);

            Comment comment1 = dao.getComment(comment.getCommentId());
            assertEquals(comment1, comment);

            dao.deleteComment(comment.getCommentId());
            comment1 = dao.getComment(comment.getCommentId());
            assertNull(comment1);
        }

    @Test
    public void getAllComments() {
        Comment comment = new Comment();
        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2018,11,15));
        comment.setCommenterName("Name1");
        comment.setComment("post1");

        comment = dao.createComment(comment);

        comment = new Comment();
        comment.setPostId(3);
        comment.setCreateDate(LocalDate.of(2015,10,10));
        comment.setCommenterName("Name2");
        comment.setComment("post2");

        comment = dao.createComment(comment);

        List<Comment> cList = dao.getAllComments();
        assertEquals(2, cList.size());
    }

    @Test
    public void getCommentByPostId() {
        Comment comment = new Comment();
        comment.setPostId(10);
        comment.setCreateDate(LocalDate.of(2018,11,11));
        comment.setCommenterName("Name1");
        comment.setComment("post1");

        dao.createComment(comment);

        List<Comment> comments = dao.getCommentsByPostId(comment.getPostId());
        assertEquals(comments.size(),1);
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setPostId(1);
        comment.setCreateDate(LocalDate.of(2018,11,15));
        comment.setCommenterName("Name1");
        comment.setComment("comment1");

        comment = dao.createComment(comment);

        comment.setPostId(2);
        comment.setCreateDate(LocalDate.of(2015,10,10));
        comment.setCommenterName("Name2");
        comment.setComment("comment2");

        dao.updateComment(comment);

        Comment comment1  = dao.createComment(comment);
        assertEquals(comment1,comment);
    }
    }


