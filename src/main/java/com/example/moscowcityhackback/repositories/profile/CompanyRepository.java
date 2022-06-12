package com.example.moscowcityhackback.repositories.profile;

import com.example.moscowcityhackback.entity.profile.Company;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface CompanyRepository extends CommonRepository<Company> {
    Company findByUser(User user);
}
