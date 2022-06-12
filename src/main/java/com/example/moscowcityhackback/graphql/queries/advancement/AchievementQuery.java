package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.Achievement;
import com.example.moscowcityhackback.services.advancement.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementQuery {

    @Autowired
    private AchievementService achievementService;

    public List<Achievement> getAchievement() {
        return achievementService.getAll();
    }

    public Achievement getAchievement(long id) {
        return achievementService.getById(id);
    }
}
