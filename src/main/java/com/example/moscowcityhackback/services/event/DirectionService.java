package com.example.moscowcityhackback.services.event;

import com.example.moscowcityhackback.entity.event.Direction;
import com.example.moscowcityhackback.repositories.event.DirectionRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class DirectionService extends AbstractService<Direction, DirectionRepository> {
    public DirectionService(DirectionRepository repository) {
        super(repository);
    }
}
