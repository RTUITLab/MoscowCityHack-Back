package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Direction;
import com.example.moscowcityhackback.repositories.DirectionRepository;

public class DirectionService extends AbstractService<Direction, DirectionRepository> {
    public DirectionService(DirectionRepository repository) {
        super(repository);
    }
}
