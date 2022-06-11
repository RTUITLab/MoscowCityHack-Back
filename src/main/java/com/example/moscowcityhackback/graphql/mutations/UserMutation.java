package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.UserInfo;
import com.example.moscowcityhackback.services.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMutation implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    public List<UserInfo> createUser(UserInfo userInfo) {
        return userService.create(userInfo);
    }

    public UserInfo updateUser(long id, UserInfo userInfo) {
        return userService.update(id, userInfo);
    }

    public List<UserInfo> deleteUser(long id) {
        return userService.delete(id);
    }

    public List<UserInfo> deleteUsers() {
        return userService.deleteAll();
    }
}
