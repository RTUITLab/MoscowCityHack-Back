package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.CompanyInfo;
import com.example.moscowcityhackback.entity.CompanyInfo;
import com.example.moscowcityhackback.services.CompanyInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyInfoQuery implements GraphQLQueryResolver {
    @Autowired
    private CompanyInfoService companyInfoService;

    public List<CompanyInfo> getCompanies() {
        return companyInfoService.getAll();
    }

    public CompanyInfo getCompany(long id) {
        return companyInfoService.getById(id);
    }
}
