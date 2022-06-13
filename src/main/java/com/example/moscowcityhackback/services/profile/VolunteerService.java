package com.example.moscowcityhackback.services.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.repositories.profile.RoleRepository;
import com.example.moscowcityhackback.repositories.profile.VolunteerRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VolunteerService extends AbstractService<Volunteer, VolunteerRepository> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public VolunteerService(VolunteerRepository repository, UserService userService, PasswordEncoder passwordEncoder1, RoleRepository roleRepository) {
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
        return repository.findById(volunteer.getId()).orElse(null);
    }

    public CredentialsQuery.Credentials createAndAuthorize(Volunteer volunteer) {
        String oldPass = volunteer.getUser().getPassword();
        volunteer.getUser().setPassword(passwordEncoder.encode(volunteer.getUser().getPassword()));
        volunteer.getUser().setRole(roleRepository.findByName(volunteer.getUser().getRole().getName()));
        repository.save(volunteer);
        return userService.authorize(volunteer.getUser().getLogin(), oldPass);
    }

    public Volunteer updateByIdAndUser(long id, Volunteer volunteer, User user) throws Exception {
        if(repository.findByIdAndUser(id, user) != null) {
            volunteer.setId(id);
            repository.save(volunteer);
            return repository.getReferenceById(id);
        }
        else
            throw new Exception("Cant find volunteer with given id and username");

    }

    public Volunteer findVolunteerByUser(User user) {
        return repository.findByUser(user);
    }

    public Volunteer getVolunteerByUserId(long userId) {
        return repository.findByUser(userService.getById(userId));
    }
}
