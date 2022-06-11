package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.UserInfo;
import com.example.moscowcityhackback.services.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;

    public List<UserInfo> getUsers() {
        return userService.getAll();
    }

    public UserInfo getUser(long id) {
        return userService.getById(id);
    }
}
