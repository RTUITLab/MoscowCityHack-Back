package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.services.profile.CompanyService;
import com.example.moscowcityhackback.services.profile.UserService;
import com.example.moscowcityhackback.services.profile.VolunteerService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CredentialsQuery implements GraphQLQueryResolver {
    private final UserService userService;
    private final TokenParser tokenParser;
    private final CompanyService companyService;
    private final VolunteerService volunteerService;

    @Autowired
    public CredentialsQuery(UserService userService, CompanyService companyService, VolunteerService volunteerService, TokenParser tokenParser) {
        this.userService = userService;
        this.tokenParser = tokenParser;
        this.companyService = companyService;
        this.volunteerService = volunteerService;
    }

    public Credentials authorize(String login, String password) {
        return userService.authorize(login, password);
    }

    public Volunteer getVolunteerByToken(DataFetchingEnvironment env) {
        return volunteerService.findVolunteerByUser(tokenParser.getUserFromRequest(env));
    }

    public Company getCompanyByToken(DataFetchingEnvironment env) {
        return companyService.findCompanyByUser(tokenParser.getUserFromRequest(env));
    }

    @AllArgsConstructor
    public static class Credentials {
        private String token;
        private String role;
    }
}
