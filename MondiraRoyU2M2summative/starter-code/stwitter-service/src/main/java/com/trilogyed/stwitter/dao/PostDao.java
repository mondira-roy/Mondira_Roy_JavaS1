package com.trilogyed.stwitter.dao;

import com.trilogyed.stwitter.model.Post;

import java.util.List;


    public interface PostDao {

        public Post createPost(Post post);

        public Post getPost(int id);

        public List<Post> getPostByPosterName(String name);

        public List<Post> getAllPosts();

        public void updatePost(Post post);

        public void deletePost(int id);
    }

