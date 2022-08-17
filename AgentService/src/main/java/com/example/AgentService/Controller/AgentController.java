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

    @GetMapping(
            value = "/agentById",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByAgentId(@RequestParam(value = "agentId") String agentId) {
        Agent agent = agentService.findByAgentId(agentId);
        try{
            return new ResponseEntity<Agent>(agentService.findByAgentId(agentId), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(
            value = "/agentByUsername",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByAgentUsername(@RequestParam(value = "username") String username) {
        Agent agent = agentService.findByUsername(username);
        try{
            return new ResponseEntity<Agent>(agentService.findByUsername(username), HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
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