package com.example.UserService;

import com.example.UserService.Model.Notification;
import com.example.UserService.Model.User;
import com.example.UserService.Service.NotificationService;
import com.example.UserService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class KafkaListeners {
    @Autowired
    private UserService userService;


    @KafkaListener(
            topics = "user_notify",
            groupId = "user_service",
            containerFactory = "userNotifyKafkaListenerContainerFactory"
    )
    void userNotifyListener(String userId){
        User user = userService.findById(userId);
        Notification notification = new Notification();
        notification.setText("Imate novu poruku");
        ArrayList<Notification> userNotifications = user.getNotifications();
        userNotifications.add(notification);
        user.setNotifications(userNotifications);
        userService.update(user);
    }

    @KafkaListener(
            topics = "user_post_notify",
            groupId = "user_service",
            containerFactory = "userPostNotifyKafkaListenerContainerFactory"
    )
    void userPostNotifyListener(String postUserId){

        User postUser = userService.findById(postUserId);
        ArrayList<User> allUsers = userService.getAllUsers();
        for (User user:allUsers
             ) {

            if(user.getFollowing().contains(postUserId))
            {
                Notification notification = new Notification();
                notification.setText(postUser.getUsername()+" je postavio novi post");
                ArrayList<Notification> userNotifications = user.getNotifications();
                userNotifications.add(notification);
                user.setNotifications(userNotifications);
                userService.update(user);
            }

        }
    }
}
