package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.graphql.queries.CredentialsQuery;
import com.example.moscowcityhackback.repositories.RoleRepository;
import com.example.moscowcityhackback.repositories.VolunteerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService extends AbstractService<Volunteer, VolunteerInfoRepository> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public VolunteerService(VolunteerInfoRepository repository, UserService userService, PasswordEncoder passwordEncoder1, RoleRepository roleRepository) {
        super(repository);
        this.userService = userService;
        this.passwordEncoder = passwordEncoder1;
        this.roleRepository = roleRepository;
    }

    @Override
    public Volunteer create(Volunteer volunteer) {
        volunteer.getUser().setPassword(passwordEncoder.encode(volunteer.getUser().getPassword()));
        volunteer.getUser().setRole(roleRepository.findByName(volunteer.getUser().getRole().getName()));
        repository.save(volunteer);
        return repository.getReferenceById(volunteer.getId());
    }

    public CredentialsQuery.Credentials createAndAuthorize(Volunteer volunteer) {
        String oldPass = volunteer.getUser().getPassword();
        volunteer.getUser().setPassword(passwordEncoder.encode(volunteer.getUser().getPassword()));
        volunteer.getUser().setRole(roleRepository.findByName(volunteer.getUser().getRole().getName()));
        repository.save(volunteer);
        return userService.authorize(volunteer.getUser().getLogin(), oldPass);
    }
}
