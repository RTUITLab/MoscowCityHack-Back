package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.UserInfo;

public interface UserRepository extends CommonRepository<UserInfo> {
    UserInfo findByLogin(String login);
}
