package com.example.moscowcityhackback.graphql.queries.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.specification.*;
import com.example.moscowcityhackback.services.event.EventService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import com.example.moscowcityhackback.graphql.filter.EventFilter;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EventQuery implements GraphQLQueryResolver {
    private final EventService eventService;
    private final TokenParser usernameParser;

    @Autowired
    public EventQuery(EventService eventService, TokenParser usernameParser) {
        this.eventService = eventService;
        this.usernameParser = usernameParser;
    }

    public List<Event> searchEvents(List<FilterRequest> filters, List<SortRequest> sorts,
                                    Integer page, Integer size) {
        SearchRequest request = SearchRequest.builder()
                .filters(filters)
                .sorts(sorts)
                .page(page)
                .size(size)
                .build();
        return eventService.searchEvents(request);
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Event> getEvents() {
        return eventService.getAll();
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Event> getEventsByToken(DataFetchingEnvironment env) {
        return eventService.getParticipatedEvents(usernameParser.getUserFromRequest(env));
    }

//    @PreAuthorize("isAuthenticated()")
    public Event getEventByTokenAndId(long id, DataFetchingEnvironment env) {
        return eventService.getByIdAndOwner(id, usernameParser.getUserFromRequest(env));
    }
}
