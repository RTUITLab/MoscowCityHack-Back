package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.graphql.queries.CredentialsQuery;
import com.example.moscowcityhackback.repositories.CompanyInfoRepository;
import com.example.moscowcityhackback.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<Company, CompanyInfoRepository> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    
    @Autowired
    public CompanyService(CompanyInfoRepository repository, UserService userService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
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
        return repository.getReferenceById(company.getId());
    }

    public CredentialsQuery.Credentials createAndAuthorize(Company company) {
        String oldPass = company.getUser().getPassword();
        company.getUser().setPassword(passwordEncoder.encode(company.getUser().getPassword()));
        company.getUser().setRole(roleRepository.findByName(company.getUser().getRole().getName()));
        repository.save(company);
        return userService.authorize(company.getUser().getLogin(), oldPass);
    }
}
