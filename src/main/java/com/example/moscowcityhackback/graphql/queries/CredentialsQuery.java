package com.example.moscowcityhackback.graphql.queries;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.moscowcityhackback.entity.User;
import com.example.moscowcityhackback.services.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CredentialsQuery implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;
    @Value("jwt.secret")
    private String jwtSecret;

    public Credentials authorize(String login, String password) {
        Credentials credentials;
        User user = userService.getByLogin(login);
        if (user !=null && BCrypt.checkpw(password, user.getPassword())) {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            String userRole = user.getRole().toString();
            String access_token = JWT.create().withSubject(login).withClaim("roles", List.of(userRole)).sign(algorithm);
            credentials = new Credentials(access_token, userRole);
        }
        else
            credentials = new Credentials("incorrect login or password", "incorrect login or password");
        return credentials;
    }

    @AllArgsConstructor
    private static class Credentials {
        private String token;
        private String role;
    }
}
