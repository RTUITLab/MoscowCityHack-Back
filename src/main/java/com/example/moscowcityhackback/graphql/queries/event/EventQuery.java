package com.example.moscowcityhackback.graphql.queries.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.services.event.EventService;
import com.example.moscowcityhackback.services.utils.UsernameFromTokenParser;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventQuery implements GraphQLQueryResolver {
    private final EventService eventService;
    private final UsernameFromTokenParser usernameParser;

    @Autowired
    public EventQuery(EventService eventService, UsernameFromTokenParser usernameParser) {
        this.eventService = eventService;
        this.usernameParser = usernameParser;
    }

    public List<Event> unprGetEvents() {
        return eventService.getAll();
    }

    public Event unprGetEvent(long id) {
        return eventService.getById(id);
    }

    @PreAuthorize("isAuthenticated()")
    public List<Event> getEvents(DataFetchingEnvironment env) {
        return eventService.getAllByOwner(usernameParser.getUserFromRequest(env));
    }

    @PreAuthorize("isAuthenticated()")
    public Event getEvent(long id, DataFetchingEnvironment env) {
        return eventService.getByIdAndOwner(id, usernameParser.getUserFromRequest(env));
    }
}
