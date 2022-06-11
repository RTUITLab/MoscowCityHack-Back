package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Company;
import com.example.moscowcityhackback.services.CompanyInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private CompanyInfoService companyInfoService;

    public List<Company> createCompany(Company company) {
        return companyInfoService.create(company);
    }

    public Company updateCompany(long id, Company company) {
        return companyInfoService.update(id, company);
    }

    public List<Company> deleteCompany(long id) {
        return companyInfoService.delete(id);
    }

    public List<Company> deleteCompanies() {
        return companyInfoService.deleteAll();
    }
}
