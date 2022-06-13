package com.example.moscowcityhackback.graphql.mutations.profile;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.services.profile.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMutation implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    // @PreAuthorize("hasAnyRole('MODERATOR')")
    public User createUser(User user) {
        return userService.create(user);
    }

    // @PreAuthorize("hasAnyRole('MODERATOR')")
    public User updateUser(long id, User user) {
        return userService.update(id, user);
    }

    // @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<User> deleteUser(long id) {
        return userService.delete(id);
    }

    // @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<User> deleteUsers() {
        return userService.deleteAll();
    }
}
