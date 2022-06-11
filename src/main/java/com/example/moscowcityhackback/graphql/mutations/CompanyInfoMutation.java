package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.CompanyInfo;
import com.example.moscowcityhackback.services.CompanyInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private CompanyInfoService companyInfoService;

    public List<CompanyInfo> createCompany(CompanyInfo company) {
        return companyInfoService.create(company);
    }

    public CompanyInfo updateCompany(long id, CompanyInfo company) {
        return companyInfoService.update(id, company);
    }

    public List<CompanyInfo> deleteCompany(long id) {
        return companyInfoService.delete(id);
    }

    public List<CompanyInfo> deleteCompanies() {
        return companyInfoService.deleteAll();
    }
}
