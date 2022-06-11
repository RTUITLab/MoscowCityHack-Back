package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Role;
import com.example.moscowcityhackback.services.RoleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleMutation implements GraphQLMutationResolver {
    @Autowired
    private RoleService roleService;

    public List<Role> createRole(Role role) {
        return roleService.create(role);
    }

    public Role updateRole(long id, Role role) {
        return roleService.update(id, role);
    }

    public List<Role> deleteRole(long id) {
        return roleService.delete(id);
    }

    public List<Role> deleteRoles() {
        return roleService.deleteAll();
    }
}
