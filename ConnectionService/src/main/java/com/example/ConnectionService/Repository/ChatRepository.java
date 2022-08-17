package com.example.ConnectionService.Repository;

import java.util.ArrayList;

import com.example.ConnectionService.Model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ChatRepository extends MongoRepository<Message, Long>{
    public ArrayList<Message> getAllMessages();
    public ArrayList<Message> getAllMessagesByReceiver(String userId);
    public Message findByMessageId(String messageId);
}
