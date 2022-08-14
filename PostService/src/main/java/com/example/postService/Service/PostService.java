package com.example.postService.Service;


import java.util.ArrayList;

import com.example.postService.Model.Comment;
import com.example.postService.Model.Post;
import com.example.postService.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
  /*  public ResponseEntity<Post> updatePost(String postId,
                                           @RequestBody Post p)  {

        Post post = postRepository.findById(postId);

        post.setDescription(p.getDescription());
        post.setLikes(p.getLikes());
        post.setTitle(p.getTitle());
        post.setDislikes(p.getDislikes());
        post.setUserId(p.getUserId());
        post.setComments(p.getComments());
        post.setImageLink(p.getImageLink());
        post.setLikedUserIds(p.getLikedUserIds());
        post.setDislikedUserIds(p.getDislikedUserIds());
        post.setLinks(p.getLinks());

        final Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);

    }*/
    public ResponseEntity<Post> commentPost(String postId,
                                           @RequestBody Comment c)  {

        Post post = postRepository.findById(postId);
        ArrayList<Comment> postComments = post.getComments();
        postComments.add(c);
        post.setComments(postComments);
        final Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);

    }


}
