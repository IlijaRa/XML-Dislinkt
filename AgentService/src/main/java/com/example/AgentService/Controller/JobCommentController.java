package com.example.AgentService.Controller;


import com.example.AgentService.Repository.CompanyRepository;
import com.example.AgentService.Service.JobCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
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
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class JobCommentController {
    @Autowired
    private JobCommentService jobCommentService;

}
