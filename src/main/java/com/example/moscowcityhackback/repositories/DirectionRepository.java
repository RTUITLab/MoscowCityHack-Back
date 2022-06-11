package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.Direction;
import com.example.moscowcityhackback.entity.Tag;

public interface DirectionRepository extends CommonRepository<Direction> {
    Direction findByName(String name);
}
