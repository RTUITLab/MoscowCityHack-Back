package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.services.EventService;
import com.example.moscowcityhackback.services.UserService;
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

    public Event createEvent(Event event) {
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


    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Event prCreateEvent(Event event, DataFetchingEnvironment env) {
        event.setOwner(usernameParser.getUserFromRequest(env));
        eventService.create(event);
        return event;
    }

    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Event prUpdateEvent(long id, Event event, DataFetchingEnvironment env) {
        event.setOwner(usernameParser.getUserFromRequest(env));
        return eventService.update(id, event);
    }


    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> prDeleteEvent(long id, DataFetchingEnvironment env) {
        return eventService.deleteByIdAndOwner(id, usernameParser.getUserFromRequest(env));
    }


    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> prDeleteEvents(DataFetchingEnvironment env) {
        return eventService.deleteAll();
    }
    
}
