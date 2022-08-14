package com.example.postService.Model;


import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private String title;
    private String description;
    private String image;
    private String userId;
    private int likes;
    private int dislikes;

   private ArrayList<String> likedUserIds;
   private ArrayList<String> dislikedUserIds;

   public Post(String title, String description, String image, String userId, int likes, int dislikes) {
         this.title = title;
         this.description = description;
         this.image = image;
         this.userId = userId;
         this.likes = likes;
         this.dislikes = dislikes;
     }

}
