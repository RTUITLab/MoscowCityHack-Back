package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractService<Event, EventRepository> {
    public EventService(EventRepository repository) {
        super(repository);
    }
}
