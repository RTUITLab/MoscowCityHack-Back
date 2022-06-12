package com.example.moscowcityhackback.graphql.mutations.advancement;

import com.example.moscowcityhackback.entity.advancement.AchievementHistory;
import com.example.moscowcityhackback.services.advancement.AchievementHistoryService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementHistoryMutation implements GraphQLMutationResolver {
    @Autowired
    private AchievementHistoryService achievementHistoryService;

    @PreAuthorize("isAuthenticated()")
    public AchievementHistory createAchievementHistory(AchievementHistory achievementHistory) {
        return achievementHistoryService.create(achievementHistory);
    }

    @PreAuthorize("isAuthenticated()")
    public AchievementHistory updateAchievementHistory(long id, AchievementHistory achievementHistory) {
        return achievementHistoryService.update(id, achievementHistory);
    }

    @PreAuthorize("isAuthenticated()")
    public List<AchievementHistory> deleteAchievementHistory(long id) {
        return achievementHistoryService.delete(id);
    }

    @PreAuthorize("isAuthenticated()")
    public List<AchievementHistory> deleteAchievementHistories() {
        return achievementHistoryService.deleteAll();
    }
}