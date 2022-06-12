package com.example.moscowcityhackback.repositories.event;

import com.example.moscowcityhackback.entity.event.Direction;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface DirectionRepository extends CommonRepository<Direction> {
    Direction findByName(String name);
}
