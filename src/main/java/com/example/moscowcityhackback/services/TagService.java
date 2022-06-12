package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.event.Tag;
import com.example.moscowcityhackback.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends AbstractService<Tag, TagRepository> {
    public TagService(TagRepository repository) {
        super(repository);
    }
}
