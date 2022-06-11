package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.UserInfo;
import com.example.moscowcityhackback.repositories.RoleRepository;
import com.example.moscowcityhackback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService extends AbstractService<UserInfo, UserRepository> implements UserDetailsService {
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    public UserService(UserRepository repository, @Autowired PasswordEncoder passwordEncoder, @Autowired RoleRepository roleRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = repository.findByLogin(username);
        return new org.springframework.security.core.userdetails.User(
                username,
                userInfo.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(userInfo.getRole().getName())));
    }

    public UserInfo getByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<UserInfo> create(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        // TODO так себе костыль
        userInfo.setRole(roleRepository.findByName(userInfo.getRole().getName()));
        repository.save(userInfo);
        return repository.findAll();
    }
}
