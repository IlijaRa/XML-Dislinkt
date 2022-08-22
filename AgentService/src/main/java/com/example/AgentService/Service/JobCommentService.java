package com.example.AgentService.Service;


import com.example.AgentService.Repository.JobCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.AgentService.Model.Agent;
import com.example.AgentService.Model.Company;
import com.example.AgentService.Repository.AgentRepository;
import com.example.AgentService.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class JobCommentService {
    @Autowired
    private JobCommentRepository jobCommentRepository;

}
