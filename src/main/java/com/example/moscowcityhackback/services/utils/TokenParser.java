package com.example.moscowcityhackback.services.utils;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.services.profile.UserService;
import graphql.kickstart.servlet.context.GraphQLServletContext;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenParser {
    @Autowired
    private UserService userService;
    public User getUserFromRequest(DataFetchingEnvironment env) {
        GraphQLServletContext context =  env.getContext();
        String token = context.getHttpServletRequest().getHeader("Authorization").substring(7);
        return userService.getByToken(token);
    }
}
