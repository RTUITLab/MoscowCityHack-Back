package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.Moderator;
import com.example.moscowcityhackback.services.ModeratorInfoService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeratorInfoQuery implements GraphQLQueryResolver {
    @Autowired
    private ModeratorInfoService moderatorInfoService;

    public List<Moderator> getModerators() {
        return moderatorInfoService.getAll();
    }

    public Moderator getModerator(long id) {
        return moderatorInfoService.getById(id);
    }
}
