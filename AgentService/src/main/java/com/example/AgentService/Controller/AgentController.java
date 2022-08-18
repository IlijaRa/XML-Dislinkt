package com.example.AgentService.Controller;

import java.util.ArrayList;
import java.util.Map;


import com.example.AgentService.AgentServiceApplication;
import com.example.AgentService.Model.Agent;
import com.example.AgentService.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AgentController {

    @Autowired
    private AgentService agentService;

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }

    @GetMapping(
            value = "/agents",
            produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAgents() {
        ArrayList<Agent> agents = agentService.getAllAgents();
        if (agents.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ArrayList<Agent>>(agents, HttpStatus.OK);
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Agent newAgent){
        try {
            return new ResponseEntity<Agent>(agentService.create(newAgent) , HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @GetMapping(path = "/agentId/{agentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByAgentId(@PathVariable String agentId) {
        Agent agent = agentService.findByAgentId(agentId);
        if (agent == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Agent>(agent, HttpStatus.OK);
    }

    @GetMapping(path = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByUsername(@PathVariable String username) {
        Agent agent = agentService.findByUsername(username);
        if (agent == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Agent>(agent, HttpStatus.OK);
    }


    @DeleteMapping(path = "/deleteAll")
    public void deleteAllAgents() {
        agentService.deleteAllAgents();
    }

    @DeleteMapping(path = "/delete/{agentId}")
    public void deleteAgent(@PathVariable String agentId) {
        agentService.deleteAgentById(agentId);
    }



}