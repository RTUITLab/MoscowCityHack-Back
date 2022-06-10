package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.User;
import com.example.moscowcityhackback.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserRepository> {
    public UserService(UserRepository repository) {
        super(repository);
    }
}
