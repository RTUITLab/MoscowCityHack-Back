package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.Moderator;
import com.example.moscowcityhackback.services.ModeratorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeratorQuery implements GraphQLQueryResolver {
    @Autowired
    private ModeratorService moderatorService;

    public List<Moderator> getModerators() {
        return moderatorService.getAll();
    }

    public Moderator getModerator(long id) {
        return moderatorService.getById(id);
    }
}
