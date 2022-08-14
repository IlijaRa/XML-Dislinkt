package com.example.postService.Service;


import java.util.ArrayList;

import com.example.postService.Model.Post;
import com.example.postService.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(Post newPost) {
        return postRepository.save(newPost);
    }

    public Post findByPostId(String postId) {
        Post post = postRepository.findById(postId);
        if (post == null) {
            throw new IllegalStateException("Post does not exist!");
        }
        return postRepository.findById(postId);

    }

    public Boolean deletePost(String postId) {
        Post post = this.findByPostId(postId);
        postRepository.delete(post);
        return true;
    }

    public ArrayList<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post create(Post post) {

        return postRepository.save(post);
    }

    public void deleteAllPosts() {
        System.out.println("Deleting all posts...");
    }

    public ArrayList<Post> getAllPostsByUserId(String userId) {
        return postRepository.findAllByUserId(userId);
    }

}
