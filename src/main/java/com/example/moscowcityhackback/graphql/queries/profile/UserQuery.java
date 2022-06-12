package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.services.profile.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    public User getUser(long id) {
        return userService.getById(id);
    }
}
