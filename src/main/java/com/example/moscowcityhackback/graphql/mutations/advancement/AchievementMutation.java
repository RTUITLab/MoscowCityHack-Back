package com.example.moscowcityhackback.graphql.mutations.advancement;

import com.example.moscowcityhackback.entity.advancement.Achievement;
import com.example.moscowcityhackback.services.advancement.AchievementService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementMutation implements GraphQLMutationResolver {
    @Autowired
    private AchievementService achievementService;

    public Achievement createAchievement(Achievement achievement) {
        return achievementService.create(achievement);
    }

    public Achievement updateAchievement(long id, Achievement achievement) {
        return achievementService.update(id, achievement);
    }

    public List<Achievement> deleteAchievement(long id) {
        return achievementService.delete(id);
    }

    public List<Achievement> deleteAchievements() {
        return achievementService.deleteAll();
    }
}
