package com.example.AgentService.Service;


import com.example.AgentService.Model.Agent;
import com.example.AgentService.Model.Company;
import com.example.AgentService.Repository.AgentRepository;
import com.example.AgentService.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service

public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company registerCompany(String ownerId,Company company) {

        Company c = companyRepository.findByName(company.getName());
        if (c!=null) {
            System.out.println("Kompanija sa datim imenom vec postoji");
            return null;
        }
        company.setApproved(false);
        company.setOwnerId(ownerId);
        if (companyRepository.save(company) != null) {
            System.out.println("Zahtev za registraciju kompanije je uspesno poslat, ceka se da je admin odobri.");

            return companyRepository.save(company);
        }
        System.out.println("Kompanija nije uspesno sacuvana.");
        return null;
    }
    public void save(Company company) {
        companyRepository.save(company);
    }

    public ArrayList<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public ArrayList<Company> getCompaniesOfSpecificOwner(String ownerId) {
        ArrayList<Company> companies = companyRepository.findByOwnerId(ownerId);
        if(companies==null)
        {
            throw new IllegalStateException("Ovaj korisnik nema kompanija");
        }
        return companies;
    }

    public ArrayList<Company> getUnapprovedCompanies() {
        return companyRepository.findByApproved(false);
    }
}
