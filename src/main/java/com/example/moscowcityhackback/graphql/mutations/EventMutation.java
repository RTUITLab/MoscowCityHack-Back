package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Event;
import com.example.moscowcityhackback.services.EventService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMutation implements GraphQLMutationResolver {
    private final EventService eventService;

    @Autowired
    public EventMutation(EventService eventService) {
        this.eventService = eventService;
    }

    public List<Event> createEvent(Event event) {
        return eventService.create(event);
    }

    public Event updateEvent(long id, Event event) {
        return eventService.update(id, event);
    }

    public List<Event> deleteEvent(long id) {
        return eventService.delete(id);
    }

    public List<Event> deleteEvents() {
        return eventService.deleteAll();
    }
}
