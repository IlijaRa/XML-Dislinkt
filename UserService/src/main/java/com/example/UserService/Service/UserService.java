package com.example.UserService.Service;

import com.example.UserService.Helper.EmailValidator;
import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private EmailValidator emailValidator = new EmailValidator();

    public void register(User user) {
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


        userRepository.save(user);
    }


    public ArrayList<User> getAllUsers(){
        return userRepository.findAll();
    }

}
