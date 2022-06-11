package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Tag;
import com.example.moscowcityhackback.repositories.TagRepository;

public class TagService extends AbstractService<Tag, TagRepository> {
    public TagService(TagRepository repository) {
        super(repository);
    }
}
