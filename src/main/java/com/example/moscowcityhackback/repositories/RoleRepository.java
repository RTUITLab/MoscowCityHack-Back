package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.Role;

public interface RoleRepository extends CommonRepository<Role>{
    Role findByName(String name);
}
