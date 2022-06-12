package com.example.moscowcityhackback.services.event;

import com.example.moscowcityhackback.entity.event.Tag;
import com.example.moscowcityhackback.repositories.event.TagRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TagService extends AbstractService<Tag, TagRepository> {
    public TagService(TagRepository repository) {
        super(repository);
    }
}
