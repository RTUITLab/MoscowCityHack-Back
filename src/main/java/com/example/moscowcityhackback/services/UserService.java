package com.example.moscowcityhackback.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.RoleRepository;
import com.example.moscowcityhackback.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService extends AbstractService<User, UserRepository> implements UserDetailsService {
    @Value("${jwt.secret}")
    private String jwtSecret;

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    public UserService(UserRepository repository, @Autowired PasswordEncoder passwordEncoder, @Autowired RoleRepository roleRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByLogin(username);
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName())));
    }

    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // TODO так себе костыль
        user.setRole(roleRepository.findByName(user.getRole().getName()));
        repository.save(user);
        return repository.getReferenceById(user.getId());
    }

    public User getByToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return repository.findByLogin(jwt.getSubject());
    }
}
