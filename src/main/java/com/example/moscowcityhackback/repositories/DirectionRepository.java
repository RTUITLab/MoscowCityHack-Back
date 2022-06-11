package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.event.Direction;

public interface DirectionRepository extends CommonRepository<Direction> {
    Direction findByName(String name);
}
