package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.AchievementHistory;
import com.example.moscowcityhackback.entity.advancement.PointsHistory;
import com.example.moscowcityhackback.services.advancement.AchievementHistoryService;
import com.example.moscowcityhackback.services.advancement.PointsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointsHistoryQuery {

    @Autowired
    private PointsHistoryService pointsHistoryService;

    public List<PointsHistory> getPointsHistory() {
        return pointsHistoryService.getAll();
    }

    public PointsHistory getPointsHistory(long id) {
        return pointsHistoryService.getById(id);
    }

}
