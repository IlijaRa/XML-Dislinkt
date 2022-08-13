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
            throw new IllegalStateException("Email nije user validnom formatu!");
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

            final User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);

    }

}
