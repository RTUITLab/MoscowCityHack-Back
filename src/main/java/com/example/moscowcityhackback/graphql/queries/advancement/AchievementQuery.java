package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.Achievement;
import com.example.moscowcityhackback.services.advancement.AchievementService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementQuery implements GraphQLQueryResolver {

    @Autowired
    private AchievementService achievementService;

    @PreAuthorize("isAuthenticated()")
    public List<Achievement> getAchievements() {
        return achievementService.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    public Achievement getAchievement(long id) {
        return achievementService.getById(id);
    }
}
