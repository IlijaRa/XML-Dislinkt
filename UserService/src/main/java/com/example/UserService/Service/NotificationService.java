package com.example.UserService.Service;


import com.example.UserService.Repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserService userService;
/*

    public Notification save(Notification notification, String userId) {
        notification.setCreationTime();
        User user = userService.findById(userId);
        if(user==null)
        {
            System.out.println("Korisnik nije pronadjen!");
            return null;
        }

        Notification savedNotification = notificationRepository.save(notification);
        UserNotification userNotification = new UserNotification();
        userNotification.setUser(user);
        userNotification.setNotification(notification);
        userNotification.setRead(false);
        userNotificationRepository.save(userNotification);
        return savedNotification;
    }*/




}
