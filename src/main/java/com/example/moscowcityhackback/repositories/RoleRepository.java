package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.profile.Role;

public interface RoleRepository extends CommonRepository<Role>{
    Role findByName(String name);
}
