package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.Event;
import com.example.moscowcityhackback.repositories.EventRepository;

public class EventService extends AbstractService<Event, EventRepository> {
    public EventService(EventRepository repository) {
        super(repository);
    }
}
