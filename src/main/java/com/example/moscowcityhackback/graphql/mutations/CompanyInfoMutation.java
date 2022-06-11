package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Company;
import com.example.moscowcityhackback.services.CompanyService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private CompanyService companyService;

    public List<Company> createCompany(Company company) {
        return companyService.create(company);
    }

    public Company updateCompany(long id, Company company) {
        return companyService.update(id, company);
    }

    public List<Company> deleteCompany(long id) {
        return companyService.delete(id);
    }

    public List<Company> deleteCompanies() {
        return companyService.deleteAll();
    }
}
