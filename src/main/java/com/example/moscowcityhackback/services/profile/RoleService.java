package com.example.moscowcityhackback.services.profile;

import com.example.moscowcityhackback.entity.profile.Role;
import com.example.moscowcityhackback.repositories.profile.RoleRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role, RoleRepository> {
    public RoleService(RoleRepository repository) {
        super(repository);
    }
    public Role getByName(String name) {
        return repository.findByName(name);
    }
}
