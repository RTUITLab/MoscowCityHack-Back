package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.services.advancement.AdvancementService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvancementQuery implements GraphQLQueryResolver {
    private final AdvancementService advancementService;
    private final TokenParser tokenParser;

    @Autowired
    public AdvancementQuery(AdvancementService advancementService, TokenParser tokenParser) {
        this.advancementService = advancementService;
        this.tokenParser = tokenParser;
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Advancement> getAdvancements() {
        return advancementService.getAll();
    }

//    @PreAuthorize("isAuthenticated()")
    public Advancement getAdvancement(long id) {
        return advancementService.getById(id);
    }

//    @PreAuthorize("isAuthenticated()")
    public Advancement getAdvancementByToken(DataFetchingEnvironment env) {
        return advancementService.getAdvancementByUser(tokenParser.getUserFromRequest(env));
    }
}
