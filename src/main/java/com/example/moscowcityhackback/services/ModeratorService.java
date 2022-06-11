package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.repositories.ModeratorInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService extends AbstractService<Moderator, ModeratorInfoRepository> {
    public ModeratorService(ModeratorInfoRepository repository) {
        super(repository);
    }
}
