package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Role;
import com.example.moscowcityhackback.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractService<Role, RoleRepository> {
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}