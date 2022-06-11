package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Volunteer;
import com.example.moscowcityhackback.repositories.VolunteerInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class VolunteerInfoService extends AbstractService<Volunteer, VolunteerInfoRepository> {
    public VolunteerInfoService(VolunteerInfoRepository repository) {
        super(repository);
    }
}
