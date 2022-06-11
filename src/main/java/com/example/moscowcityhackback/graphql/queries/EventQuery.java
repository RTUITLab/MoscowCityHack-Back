package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.Event;
import com.example.moscowcityhackback.services.EventService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventQuery implements GraphQLQueryResolver {
    private final EventService eventService;

    @Autowired
    public EventQuery(EventService eventService) {
        this.eventService = eventService;
    }

    public List<Event> getEvents() {
        return eventService.getAll();
    }

    public Event getEvent(long id) {
        return eventService.getById(id);
    }
}
