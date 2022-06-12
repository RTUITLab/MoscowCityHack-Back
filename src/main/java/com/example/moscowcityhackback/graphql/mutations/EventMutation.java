package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.services.EventService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMutation implements GraphQLMutationResolver {
    private final EventService eventService;

    @Autowired
    public EventMutation(EventService eventService) {
        this.eventService = eventService;
    }

    @PreAuthorize("isAuthenticated()")
    public List<Event> createEvent(Event event) {
        return eventService.create(event);
    }

    @PreAuthorize("isAuthenticated()")
    public Event updateEvent(long id, Event event) {
        return eventService.update(id, event);
    }

    @PreAuthorize("isAuthenticated()")
    public List<Event> deleteEvent(long id) {
        return eventService.delete(id);
    }

    @PreAuthorize("isAuthenticated()")
    public List<Event> deleteEvents() {
        return eventService.deleteAll();
    }
}
