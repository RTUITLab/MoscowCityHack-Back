package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Company;
import com.example.moscowcityhackback.repositories.CompanyInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService extends AbstractService<Company, CompanyInfoRepository> {
    public CompanyInfoService(CompanyInfoRepository repository) {
        super(repository);
    }
}
