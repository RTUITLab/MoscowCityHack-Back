package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Moderator;
import com.example.moscowcityhackback.repositories.ModeratorInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeratorInfoService extends AbstractService<Moderator, ModeratorInfoRepository> {
    public ModeratorInfoService(ModeratorInfoRepository repository) {
        super(repository);
    }
}
