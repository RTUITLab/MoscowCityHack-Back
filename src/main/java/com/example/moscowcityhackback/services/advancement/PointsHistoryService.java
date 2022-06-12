package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.PointsHistory;
import com.example.moscowcityhackback.repositories.advancement.PointsHistoryRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class PointsHistoryService extends AbstractService<PointsHistory, PointsHistoryRepository> {
    public PointsHistoryService(PointsHistoryRepository repository) {
        super(repository);
    }
}
