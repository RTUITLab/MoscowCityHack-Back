package com.example.moscowcityhackback.graphql.mutations.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.services.profile.CompanyService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyMutation implements GraphQLMutationResolver {
    @Autowired
    private CompanyService companyService;

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Company createCompany(Company company) {
        return companyService.create(company);
    }

    @PreAuthorize("hasAnyRole('MODERATOR', 'COMPANY')")
    public Company updateCompany(long id, Company company) {
        return companyService.update(id, company);
    }

    @PreAuthorize("hasAnyRole('MODERATOR', 'COMPANY')")
    public List<Company> deleteCompany(long id) {
        return companyService.delete(id);
    }

    @PreAuthorize("hasAnyRole('MODERATOR', 'COMPANY')")
    public List<Company> deleteCompanies() {
        return companyService.deleteAll();
    }

    @PreAuthorize("isAnonymous()")
    public CredentialsQuery.Credentials registerAuthorizeCom(Company company) {
        return companyService.createAndAuthorize(company);
    }
}
