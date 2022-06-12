package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.Achievement;
import com.example.moscowcityhackback.repositories.advancement.AchievementRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AchievementService extends AbstractService<Achievement, AchievementRepository> {
    public AchievementService(AchievementRepository repository) {
        super(repository);
    }
}
