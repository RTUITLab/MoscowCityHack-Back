package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.repositories.ModeratorInfoRepository;
import com.example.moscowcityhackback.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorService extends AbstractService<Moderator, ModeratorInfoRepository> {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public ModeratorService(ModeratorInfoRepository repository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Moderator> create(Moderator moderator) {
        moderator.getUser().setPassword(passwordEncoder.encode(moderator.getUser().getPassword()));
        // TODO так себе костыль
        moderator.getUser().setRole(roleRepository.findByName(moderator.getUser().getRole().getName()));
        repository.save(moderator);
        return repository.findAll();
    }
}
