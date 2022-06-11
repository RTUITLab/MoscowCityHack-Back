package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Company;
import com.example.moscowcityhackback.repositories.CompanyInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends AbstractService<Company, CompanyInfoRepository> {
    public CompanyService(CompanyInfoRepository repository) {
        super(repository);
    }
}
