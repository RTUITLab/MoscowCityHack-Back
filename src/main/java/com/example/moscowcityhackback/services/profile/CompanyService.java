package com.example.moscowcityhackback.services.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.repositories.profile.CompanyRepository;
import com.example.moscowcityhackback.repositories.profile.RoleRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<Company, CompanyRepository> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    
    @Autowired
    public CompanyService(CompanyRepository repository, UserService userService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(repository);
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Company create(Company company) {
        company.getUser().setPassword(passwordEncoder.encode(company.getUser().getPassword()));
        company.getUser().setRole(roleRepository.findByName(company.getUser().getRole().getName()));
        repository.save(company);
        return repository.findById(company.getId()).orElse(null);
    }

    public CredentialsQuery.Credentials createAndAuthorize(Company company) {
        String oldPass = company.getUser().getPassword();
        company.getUser().setPassword(passwordEncoder.encode(company.getUser().getPassword()));
        company.getUser().setRole(roleRepository.findByName(company.getUser().getRole().getName()));
        repository.save(company);
        return userService.authorize(company.getUser().getLogin(), oldPass);
    }

    public Company findCompanyByUser(User user) {
        return repository.findByUser(user);
    }
}
