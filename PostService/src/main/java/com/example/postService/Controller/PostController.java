package com.example.postService.Controller;

import com.example.postService.Model.Comment;
import com.example.postService.Model.Post;
import com.example.postService.Service.CommentService;
import com.example.postService.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping(path = "/post")
@CrossOrigin(origins = "*")
public class PostController {


    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
    //get all posts
    @GetMapping(
            value = "/posts",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPosts(){
        ArrayList<Post> posts = postService.getAllPosts();
        if(posts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ArrayList<Post>>(postService.getAllPosts(), HttpStatus.OK);
    }

    //get all posts by userId
    @GetMapping( value = "/post",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllPostsByUserId(@RequestParam(value="postId") String userId){
        ArrayList<Post> posts = postService.getAllPostsByUserId(userId);
        if(posts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ArrayList<Post>>(postService.getAllPostsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Post newPost){
        try {
            return new ResponseEntity<Post>(postService.create(newPost) , HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    //delete post by postId
    @DeleteMapping(value="/post")
    public ResponseEntity<?> deletePost(@RequestParam(value = "postId") String postId){
        try{
            postService.deletePost(postId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }

    //put post by postId
    @PostMapping(path = "/{postId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putPost(@PathVariable String postId, @RequestBody Post post){
        try{
            postService.save(post);
            return new ResponseEntity<Post>(post ,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }
    //comment on post
    @PutMapping(path = "posts/{postId}")
    public ResponseEntity<Post> commentPost(@PathVariable String postId,@RequestBody Comment comment){
        Post savedPost= this.postService.commentPost(postId,comment).getBody();
        return new ResponseEntity<>(savedPost,HttpStatus.CREATED);
    }

    // get all comments from one post

    @GetMapping(path="/posts/{postId}/comments")
    public ResponseEntity<ArrayList<Comment>> getAllCommentsFromPost(@PathVariable String postId){
        Post post= postService.findByPostId(postId);
        ArrayList<Comment> commentsFromPost = post.getComments();
        return new ResponseEntity<>(commentsFromPost,HttpStatus.OK);
    }

    // get all user id's who like post
    @GetMapping(path="/posts/{postId}/likes")
    public ResponseEntity<ArrayList<String>> getAllLikedUserIdsFromPost(@PathVariable String postId){
        Post post= postService.findByPostId(postId);
        ArrayList<String> likedUserIdsFromPost = post.getLikedUserIds();
        return new ResponseEntity<>(likedUserIdsFromPost,HttpStatus.OK);
    }
    // get all user id's who disliked post
    @GetMapping(path="/posts/{postId}/dislikes")
    public ResponseEntity<ArrayList<String>> getAllDislikedUserIdsFromPost(@PathVariable String postId){
        Post post= postService.findByPostId(postId);
        ArrayList<String> dislikedUserIdsFromPost = post.getDislikedUserIds();
        return new ResponseEntity<>(dislikedUserIdsFromPost,HttpStatus.OK);
    }

}