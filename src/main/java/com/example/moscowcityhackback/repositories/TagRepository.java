package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.event.Tag;

public interface TagRepository extends CommonRepository<Tag> {
    Tag findByName(String name);
}
