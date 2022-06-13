package com.example.moscowcityhackback.graphql.mutations.advancement;

import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.services.advancement.AdvancementService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class AdvancementMutation implements GraphQLMutationResolver {
    private final AdvancementService advancementService;
    private final TokenParser tokenParser;

    @Autowired
    public AdvancementMutation(AdvancementService advancementService, TokenParser tokenParser) {
        this.advancementService = advancementService;
        this.tokenParser = tokenParser;
    }

//    @PreAuthorize("isAuthenticated()")
    public Advancement createAdvancement(Advancement advancement) {
        return advancementService.create(advancement);
    }

//    @PreAuthorize("isAuthenticated()")
    @Transactional
    public Advancement updateAdvancementByToken(Advancement advancement, DataFetchingEnvironment env) {
        return advancementService.updateAdvancementByUser(advancement, tokenParser.getUserFromRequest(env));
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Advancement> deleteAdvancement(long id) {
        return advancementService.delete(id);
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Advancement> deleteAdvancements() {
        return advancementService.deleteAll();
    }
}
