package com.example.AgentService.Repository;

import com.example.AgentService.Model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.AgentService.Model.Agent;
import com.example.AgentService.Model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface JobCommentRepository extends MongoRepository<Company, Long> {

}
