package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.services.profile.ModeratorService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeratorQuery implements GraphQLQueryResolver {
    @Autowired
    private ModeratorService moderatorService;

//    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> getModerators() {
        return moderatorService.getAll();
    }

//    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator getModerator(long id) {
        return moderatorService.getById(id);
    }
}
