package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.Role;
import com.example.moscowcityhackback.services.RoleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleQuery implements GraphQLQueryResolver {
    @Autowired
    private RoleService roleService;

    public List<Role> getRoles() {
        return roleService.getAll();
    }

    public Role getRole(long id) {
        return roleService.getById(id);
    }
}
