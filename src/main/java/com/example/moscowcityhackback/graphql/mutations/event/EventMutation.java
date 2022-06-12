package com.example.moscowcityhackback.graphql.mutations.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.services.event.EventService;
import com.example.moscowcityhackback.services.utils.UsernameFromTokenParser;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EventMutation implements GraphQLMutationResolver {
    private final EventService eventService;
    private final UsernameFromTokenParser usernameParser;

    @Autowired
    public EventMutation(EventService eventService, UsernameFromTokenParser usernameParser) {
        this.eventService = eventService;
        this.usernameParser = usernameParser;
    }

    public Event unprCreateEvent(Event event) {
        return eventService.create(event);
    }

    public Event unprUpdateEvent(long id, Event event) {
        return eventService.update(id, event);
    }

    public List<Event> unprDeleteEvent(long id) {
        return eventService.delete(id);
    }

    public List<Event> unprDeleteEvents() {
        return eventService.deleteAll();
    }


    @Transactional
    public Event createEvent(Event event, DataFetchingEnvironment env) {
        event.setPublished(false);
        event.setOwner(usernameParser.getUserFromRequest(env));
        eventService.create(event);
        return event;
    }

    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Event updateEvent(long id, Event event, DataFetchingEnvironment env) {
        event.setOwner(usernameParser.getUserFromRequest(env));
        return eventService.update(id, event);
    }


    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> deleteEvent(long id, DataFetchingEnvironment env) {
        return eventService.deleteByIdAndOwner(id, usernameParser.getUserFromRequest(env));
    }


    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> deleteEvents(DataFetchingEnvironment env) {
        return eventService.deleteAll();
    }
    
}
