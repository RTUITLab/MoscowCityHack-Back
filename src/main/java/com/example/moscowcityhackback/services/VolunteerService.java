package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.repositories.RoleRepository;
import com.example.moscowcityhackback.repositories.VolunteerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService extends AbstractService<Volunteer, VolunteerInfoRepository> {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public VolunteerService(VolunteerInfoRepository repository, PasswordEncoder passwordEncoder1, RoleRepository roleRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder1;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Volunteer> create(Volunteer volunteer) {
        volunteer.getUser().setPassword(passwordEncoder.encode(volunteer.getUser().getPassword()));
        // TODO так себе костыль
        volunteer.getUser().setRole(roleRepository.findByName(volunteer.getUser().getRole().getName()));
        repository.save(volunteer);
        return repository.findAll();
    }
}
