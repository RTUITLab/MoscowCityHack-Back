package com.example.moscowcityhackback.graphql.queries.profile;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.services.CompanyService;
import com.example.moscowcityhackback.services.RoleService;
import com.example.moscowcityhackback.services.UserService;
import com.example.moscowcityhackback.services.VolunteerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CredentialsQuery implements GraphQLQueryResolver {
    private UserService userService;
//    private CompanyService companyService;
//    private VolunteerService volunteerService;
    private RoleService roleService;
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Autowired
    public CredentialsQuery(UserService userService, CompanyService companyService, VolunteerService volunteerService) {
        this.userService = userService;
    }

    public Credentials authorize(String login, String password) {
        return userService.authorize(login, password);
    }

    @AllArgsConstructor
    public static class Credentials {
        private String token;
        private String role;
    }
}
