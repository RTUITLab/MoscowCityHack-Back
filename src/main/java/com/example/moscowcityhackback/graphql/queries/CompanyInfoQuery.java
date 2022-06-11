package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.services.CompanyService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyInfoQuery implements GraphQLQueryResolver {
    @Autowired
    private CompanyService companyService;

    public List<Company> getCompanies() {
        return companyService.getAll();
    }

    public Company getCompany(long id) {
        return companyService.getById(id);
    }
}
