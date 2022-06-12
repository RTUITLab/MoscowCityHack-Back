package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.AchievementHistory;
import com.example.moscowcityhackback.services.advancement.AchievementHistoryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchievementHistoryQuery implements GraphQLQueryResolver {

    @Autowired
    private AchievementHistoryService achievementHistoryService;

    public List<AchievementHistory> getAchievementHistories() {
        return achievementHistoryService.getAll();
    }

    public AchievementHistory getAchievementHistory(long id) {
        return achievementHistoryService.getById(id);
    }

}
