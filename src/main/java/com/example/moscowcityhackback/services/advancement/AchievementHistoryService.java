package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.AchievementHistory;
import com.example.moscowcityhackback.repositories.advancement.AchievementHistoryRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AchievementHistoryService extends AbstractService<AchievementHistory, AchievementHistoryRepository> {
    public AchievementHistoryService(AchievementHistoryRepository repository) {
        super(repository);
    }
}
