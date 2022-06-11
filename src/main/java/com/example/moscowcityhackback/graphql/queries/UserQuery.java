package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.services.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;

    public List<User> getUsers() {
        return userService.getAll();
    }

    public User getUser(long id) {
        return userService.getById(id);
    }
}
