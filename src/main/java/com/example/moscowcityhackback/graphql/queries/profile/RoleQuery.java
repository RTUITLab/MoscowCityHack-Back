package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Role;
import com.example.moscowcityhackback.services.profile.RoleService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleQuery implements GraphQLQueryResolver {
    @Autowired
    private RoleService roleService;

    @PreAuthorize("isAuthenticated()")
    public List<Role> getRoles() {
        return roleService.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    public Role getRole(long id) {
        return roleService.getById(id);
    }
}
