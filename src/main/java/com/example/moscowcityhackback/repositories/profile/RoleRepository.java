package com.example.moscowcityhackback.repositories.profile;

import com.example.moscowcityhackback.entity.profile.Role;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface RoleRepository extends CommonRepository<Role> {
    Role findByName(String name);
}
