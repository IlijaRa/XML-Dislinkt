package com.example.UserService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String gender;

  //  private LocalDate dateOfBirth;

    private String biography;
    private String skills;
    private String interests;
    private String education;
    private Boolean isPrivate;

    private ArrayList<String> following;
    private ArrayList<String> followRequests;
    private ArrayList<String> blocked;

    public Boolean isPrivate() {
        return isPrivate;
    }

    public ArrayList<String> getFollowing() {
        if(following==null)
            following = new ArrayList<String>();
        return following;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    public ArrayList<String> getFollowRequests() {
        if(followRequests==null)
            followRequests = new ArrayList<String>();
        return followRequests;
    }

    public void setFollowRequests(ArrayList<String> followRequests) {
        this.followRequests = followRequests;
    }

    public ArrayList<String> getBlocked() {
        if(blocked==null)
            blocked = new ArrayList<String>();
        return blocked;
    }

    public void setBlocked(ArrayList<String> blocked) {
        this.blocked = blocked;
    }



    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




}
