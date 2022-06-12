package com.example.moscowcityhackback.graphql.mutations.advancement;

import com.example.moscowcityhackback.entity.advancement.PointsHistory;
import com.example.moscowcityhackback.services.advancement.PointsHistoryService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PointsHistoryMutation implements GraphQLMutationResolver {
    @Autowired
    private PointsHistoryService pointsHistoryService;

    public PointsHistory createPointsHistory(PointsHistory pointsHistory) {
        return pointsHistoryService.create(pointsHistory);
    }

    public PointsHistory updatePointsHistory(long id, PointsHistory pointsHistory) {
        return pointsHistoryService.update(id, pointsHistory);
    }

    public List<PointsHistory> deletePointsHistory(long id) {
        return pointsHistoryService.delete(id);
    }

    public List<PointsHistory> deletePointsHistories() {
        return pointsHistoryService.deleteAll();
    }
}
