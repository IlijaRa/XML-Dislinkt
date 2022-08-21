package com.example.JobOfferService.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JobOfferController {

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}
