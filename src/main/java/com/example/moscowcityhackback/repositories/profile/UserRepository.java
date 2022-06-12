package com.example.moscowcityhackback.repositories.profile;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface UserRepository extends CommonRepository<User> {
    User findByLogin(String login);
}
