package com.example.AgentService.Repository;

import java.util.ArrayList;

import com.example.AgentService.Model.Agent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository extends MongoRepository<Agent, String>{

     Agent findByUsername(String username);
     Agent getById(String agentId);

    public ArrayList<Agent> findAll();
    public ArrayList<Agent> findByUsernameContaining(String usernamePart);

}