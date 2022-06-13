package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.services.profile.CompanyService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyQuery implements GraphQLQueryResolver {
    private final CompanyService companyService;

    @Autowired
    public CompanyQuery(CompanyService companyService) {
        this.companyService = companyService;
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Company> getCompanies() {
        return companyService.getAll();
    }

//    @PreAuthorize("isAuthenticated()")
    public Company getCompany(long id) {
        return companyService.getById(id);
    }

//    @PreAuthorize("isAuthenticated()")
    public Company getCompanyByUserId(long userId) {
        return companyService.getCompanyByUserId(userId);
    }
}
