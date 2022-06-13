package com.example.moscowcityhackback.graphql.mutations.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.services.event.EventService;
import com.example.moscowcityhackback.services.utils.TokenParser;
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
    private final TokenParser usernameParser;

    @Autowired
    public EventMutation(EventService eventService, TokenParser usernameParser) {
        this.eventService = eventService;
        this.usernameParser = usernameParser;
    }

    @Transactional
    public Event createEvent(Event event) {
        event.setPublished(false);
        eventService.create(event);
        return event;
    }

    @Transactional
//    @PreAuthorize("isAuthenticated()")
    public Event createEventWithToken(Event event, DataFetchingEnvironment env) {
        event.setPublished(false);
        event.setOwner(usernameParser.getUserFromRequest(env));
        eventService.create(event);
        return event;
    }

//    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Event updateEvent(long id, Event event, DataFetchingEnvironment env) {
        event.setOwner(usernameParser.getUserFromRequest(env));
        return eventService.update(id, event);
    }


//    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> deleteEvent(long id, DataFetchingEnvironment env) {
        return eventService.deleteByIdAndOwner(id, usernameParser.getUserFromRequest(env));
    }


//    @PreAuthorize("isAuthenticated()")
    @Transactional
    public List<Event> deleteEvents(DataFetchingEnvironment env) {
        return eventService.deleteAll();
    }
    
}
