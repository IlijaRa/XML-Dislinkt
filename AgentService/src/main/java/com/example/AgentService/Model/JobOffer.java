package com.example.AgentService.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "offers")
public class JobOffer {
    @Id
    private String id;
    private String position;
    private String description;
    private String location;
    private ArrayList<String> requirements = new ArrayList<>();
    private ArrayList<String> daily_activities = new ArrayList<>();
    private String CompanyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(ArrayList<String> requirements) {
        this.requirements = requirements;
    }

    public ArrayList<String> getDaily_activities() {
        return daily_activities;
    }

    public void setDaily_activities(ArrayList<String> daily_activities) {
        this.daily_activities = daily_activities;
    }

    public String getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(String companyId) {
        CompanyId = companyId;
    }
}
