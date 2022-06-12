package com.example.moscowcityhackback.services.profile;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.repositories.profile.ModeratorRepository;
import com.example.moscowcityhackback.repositories.profile.RoleRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService extends AbstractService<Moderator, ModeratorRepository> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public ModeratorService(ModeratorRepository repository, UserService userService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(repository);
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Moderator create(Moderator moderator) {
        moderator.getUser().setPassword(passwordEncoder.encode(moderator.getUser().getPassword()));
        moderator.getUser().setRole(roleRepository.findByName(moderator.getUser().getRole().getName()));
        repository.save(moderator);
        return repository.findById(moderator.getId()).orElse(null);
    }

    public CredentialsQuery.Credentials createAndAuthorize(Moderator moderator) {
        String oldPass = moderator.getUser().getPassword();
        moderator.getUser().setPassword(passwordEncoder.encode(moderator.getUser().getPassword()));
        moderator.getUser().setRole(roleRepository.findByName(moderator.getUser().getRole().getName()));
        repository.save(moderator);
        return userService.authorize(moderator.getUser().getLogin(), oldPass);
    }
}
