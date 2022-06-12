package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.AchievementHistory;
import com.example.moscowcityhackback.entity.advancement.PointsHistory;
import com.example.moscowcityhackback.services.advancement.AchievementHistoryService;
import com.example.moscowcityhackback.services.advancement.PointsHistoryService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointsHistoryQuery implements GraphQLQueryResolver {

    @Autowired
    private PointsHistoryService pointsHistoryService;

    @PreAuthorize("isAuthenticated()")
    public List<PointsHistory> getPointsHistories() {
        return pointsHistoryService.getAll();
    }

    @PreAuthorize("isAuthenticated()")
    public PointsHistory getPointsHistory(long id) {
        return pointsHistoryService.getById(id);
    }
}
