package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.profile.User;

public interface UserRepository extends CommonRepository<User> {
    User findByLogin(String login);
}
