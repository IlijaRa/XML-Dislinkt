package com.example.UserService.Service;

import com.example.UserService.Helper.EmailValidator;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Console;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private EmailValidator emailValidator = new EmailValidator();


    public User create(User user) {
        boolean isValidEmail = emailValidator.test(user.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("Email nije u validnom formatu!");
        }

        boolean userExists = userRepository.findByEmail(user.getEmail()) != null;
        if(userExists){
            throw new IllegalStateException("Email ime vec postoji!");
        }
        userExists = userRepository.findByUsername(user.getUsername()) != null;
        if(userExists){
            throw new IllegalStateException("Korisnicko ime vec postoji!");
        }


        return userRepository.save(user);
    }


    public ArrayList<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new IllegalStateException("Korisnik ne postoji!");
        }
        return user;
    }
    public User findByEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new IllegalStateException("Korisnik ne postoji!");
        }
        return user;
    }
    public Boolean deleteUserByUsername(String username){
        User user = this.findByUsername(username);
        userRepository.delete(user);
        return true;
    }
    public Boolean deleteUserByEmail(String email){
        User user = this.findByEmail(email);
        userRepository.delete(user);
        return true;
    }


    public void deleteAllUsers(){
        userRepository.deleteAll();
    }

    public ResponseEntity<User> updateUser(String userId,
                                           @RequestBody User u)  {

            User user = userRepository.findById(userId);

            System.out.println("prosledjeni user " + u.getUsername());
            System.out.println("pronadjeni user " + user.getUsername());

            user.setUsername(u.getUsername());
            user.setPassword(u.getPassword());
            user.setName(u.getName());
            user.setEmail(u.getEmail());
            user.setPhone(u.getPhone());
            user.setGender(u.getGender());
            user.setBiography(u.getBiography());
            user.setInterests(u.getInterests());
            user.setEducation(u.getEducation());
            user.setExperience(u.getExperience());
            user.setSkills(u.getSkills());
            user.setIsPrivate(u.getIsPrivate());

            final User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);

    }
    public ArrayList<User> searchUserByUsername(String partOfUsername)
    {
        return userRepository.findByUsernameContaining(partOfUsername);
    }

    //follow user
    public User follow(String followerUsername, String toFollowUsername) {
        System.out.println(followerUsername);
        System.out.println(toFollowUsername);
        User followerUser = userRepository.findByUsername(followerUsername);
        User toFollowUser = userRepository.findByUsername(toFollowUsername);

        if(followerUser == null){
            throw new IllegalStateException("followerUser does not exist!");
        }
        if(toFollowUser == null){
            throw new IllegalStateException("toFollowUser does not exist!");
        }
        if(followerUser.getFollowing().contains(toFollowUsername)){
            throw new IllegalStateException("You already follow this user!");
        }
        if(followerUser.getBlocked().contains(toFollowUsername))
        {
            throw new IllegalStateException("You have blocked this user!");
        }
        if(toFollowUser.isPrivate()){
            toFollowUser.getFollowRequests().add(followerUsername);
            return userRepository.save(toFollowUser);
        }else{
            followerUser.getFollowing().add(toFollowUsername);
            return userRepository.save(followerUser);
        }
    }
    public User block(String userBlockingUsername,String userBlockedUsername){
        User userBlocking=userRepository.findByUsername(userBlockingUsername);
        User userBlocked=userRepository.findByUsername(userBlockedUsername);
        ArrayList<String> blockedUsers = userBlocking.getBlocked();
        if(userBlocking==null){
            throw new IllegalStateException("User who is trying to block does not exist!");
        }

        if(userBlocked==null){
            throw new IllegalStateException("User being blocked does not exist!");
        }

        if( userBlocking.getBlocked().contains(userBlockedUsername)){
            throw new IllegalStateException("You already blocked this user!");
        }

        if( userBlocking.getFollowing().contains(userBlockedUsername)){
            userBlocking.getFollowing().remove(userBlockedUsername);
        }

        if( userBlocking.getFollowRequests().contains(userBlockedUsername)){
            userBlocking.getFollowRequests().remove(userBlockedUsername);
        }

        if(userBlocked.getFollowing().contains(userBlockingUsername)){
            userBlocked.getFollowing().remove(userBlockingUsername);
        }

        if( userBlocked.getFollowRequests().contains(userBlockingUsername)){
            userBlocked.getFollowRequests().remove(userBlockingUsername);
        }

       /* if(blockedUsers.isEmpty())
            System.out.println("lista je prazna pre dodavanja");*/
        blockedUsers.add(userBlockedUsername);
        System.out.println("blocked users "+ blockedUsers.get(0));
        userBlocking.setBlocked(blockedUsers);

        userRepository.save(userBlocked);
        return userRepository.save(userBlocking);

    }


}
