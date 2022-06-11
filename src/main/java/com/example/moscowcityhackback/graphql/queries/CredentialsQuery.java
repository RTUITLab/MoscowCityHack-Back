package com.example.moscowcityhackback.graphql.queries;

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
//        this.companyService = companyService;
//        this.volunteerService = volunteerService;
    }

    public Credentials authorize(String login, String password) {
        Credentials credentials;
        User user = userService.getByLogin(login);
        if (user !=null && BCrypt.checkpw(password, user.getPassword())) {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
            String userRole = user.getRole().getName();
            String access_token = JWT.create().withSubject(login).withClaim("roles", List.of(userRole)).sign(algorithm);
            credentials = new Credentials(access_token, userRole);
        }
        else
            credentials = new Credentials("incorrect login or password", "incorrect login or password");
        return credentials;
    }

//    @Transactional
//    public Credentials registerCompany(String name, User user) {
//        Role role = roleService.getByName("ROLE_COMPANY");
//        user.setRole(role);
//        userService.create(user);
//        companyService.create(new Company(name, user));
//    }
//
//    public Credentials register() {
//
//    }

    @AllArgsConstructor
    private static class Credentials {
        private String token;
        private String role;
    }
}
