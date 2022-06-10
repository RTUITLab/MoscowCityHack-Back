package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.ModeratorInfo;
import com.example.moscowcityhackback.repositories.ModeratorInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeratorInfoService extends AbstractService<ModeratorInfo, ModeratorInfoRepository> {
    public ModeratorInfoService(ModeratorInfoRepository repository) {
        super(repository);
    }
}
