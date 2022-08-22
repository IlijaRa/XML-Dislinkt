package com.example.AgentService.Controller;


import com.example.AgentService.Service.CompanyService;
import com.example.AgentService.Service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
}
