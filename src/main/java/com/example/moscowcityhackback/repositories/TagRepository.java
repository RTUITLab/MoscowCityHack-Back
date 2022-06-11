package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.Tag;

public interface TagRepository extends CommonRepository<Tag> {
    Tag findByName(String name);
}
