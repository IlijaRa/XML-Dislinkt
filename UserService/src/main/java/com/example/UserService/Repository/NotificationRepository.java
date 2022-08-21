package com.example.UserService.Repository;

import com.example.UserService.Model.Notification;
import com.example.UserService.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, Long> {
    Notification findById(String id);

}
