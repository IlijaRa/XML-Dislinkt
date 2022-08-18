package com.example.ConnectionService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.ConnectionService.Repository.*;
import com.example.ConnectionService.Model.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    //get all messages
    public ArrayList<Message> getAllMessages(){
        return chatRepository.findAll();
    }

    //get all messages by receiverId
    public ArrayList<Message> getAllMessagesByReceiver(String userId) {
        return chatRepository.findAllByReceiverId(userId);
    }

    //create new message
    public Message createMessage(Message newMessage) {
        return chatRepository.save(newMessage);
    }

    public Boolean deleteSingleMessage(String messageId) {
        Message message = chatRepository.findById(messageId);
        chatRepository.delete(message);
        return true;
    }

}
