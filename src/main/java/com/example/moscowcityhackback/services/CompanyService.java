package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.repositories.CompanyInfoRepository;
import com.example.moscowcityhackback.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends AbstractService<Company, CompanyInfoRepository> {
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    
    @Autowired
    public CompanyService(CompanyInfoRepository repository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Company> create(Company company) {
        company.getUser().setPassword(passwordEncoder.encode(company.getUser().getPassword()));
        // TODO так себе костыль
        company.getUser().setRole(roleRepository.findByName(company.getUser().getRole().getName()));
        repository.save(company);
        return repository.findAll();
    }
}
