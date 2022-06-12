package com.example.moscowcityhackback.repositories.event;

import com.example.moscowcityhackback.entity.event.Tag;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface TagRepository extends CommonRepository<Tag> {
    Tag findByName(String name);
}
