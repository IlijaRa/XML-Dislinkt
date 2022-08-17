package com.example.AgentService.Service;



import com.example.AgentService.Model.Agent;
import com.example.AgentService.Repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    public ArrayList<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent create(Agent agent) {

       boolean agentExist = agentRepository.findByUsername(agent.getUsername()) != null;
        if(agentExist){
            throw new IllegalStateException("Korisnicko ime agenta vec postoji!");
        }

        return agentRepository.save(agent);
    }

    public Agent findByUsername(String username) {
        Agent agent = agentRepository.findByUsername(username);
        if(agent == null){
            throw new IllegalStateException("Agent ne postoji!");
        }
        return agent;

    }

    public Agent findByAgentId(String agentId) {
        Agent agent = agentRepository.getById(agentId);
        if(agent==null)
        {
            throw new IllegalStateException("Agent ne postoji");
        }
        return agent;
      //  return agentRepository.getById(agentId);
    }



    public ArrayList<Agent> findByUsernameContaining(String usernamePart) {
        return agentRepository.findByUsernameContaining(usernamePart);
    }

    public void deleteAllAgents() {
        agentRepository.deleteAll();
    }

    public Boolean deleteAgentById(String agentId) {
        Agent agent = agentRepository.getById(agentId);
        if (agent == null)
            throw new IllegalArgumentException("This agent is not found");
        agentRepository.delete(agent);
        return true;

    }

    public void save(Agent agent) {
        agentRepository.save(agent);
    }



}