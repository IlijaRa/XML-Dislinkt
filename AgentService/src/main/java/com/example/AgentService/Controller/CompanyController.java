package com.example.AgentService.Controller;

import com.example.AgentService.Model.Agent;
import com.example.AgentService.Model.Company;
import com.example.AgentService.Service.AgentService;
import com.example.AgentService.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    private CompanyService companyService;
// get all companies
    @GetMapping(
            value = "/companies",
            produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAgents() {
        ArrayList<Company> companies = companyService.getAllCompanies();
        if (companies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<ArrayList<Company>>(companies, HttpStatus.OK);
    }
    //get all companies of specific owner
    @GetMapping(path="/{ownerId}/companies")
    public ResponseEntity<ArrayList<Company>> getAllCommentsFromPost(@PathVariable String ownerId){
        ArrayList<Company> companies = companyService.getCompaniesOfSpecificOwner(ownerId);
        if (companies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    //register company
    @PostMapping(path = "/{ownerId}/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putPost(@PathVariable String ownerId, @RequestBody Company company){
        try{
            companyService.registerCompany(ownerId,company);
            return new ResponseEntity<Company>(company , HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }

}
