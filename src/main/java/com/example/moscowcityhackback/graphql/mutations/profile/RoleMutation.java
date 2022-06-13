package com.example.moscowcityhackback.graphql.mutations.profile;

import com.example.moscowcityhackback.entity.profile.Role;
import com.example.moscowcityhackback.services.profile.RoleService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PreAuthorize("hasAuthority('MODERATOR')")
public class RoleMutation implements GraphQLMutationResolver {
    @Autowired
    private RoleService roleService;

//    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Role createRole(Role role) {
        return roleService.create(role);
    }

//    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Role updateRole(long id, Role role) {
        return roleService.update(id, role);
    }

//    @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<Role> deleteRole(long id) {
        return roleService.delete(id);
    }

//    @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<Role> deleteRoles() {
        return roleService.deleteAll();
    }
}
