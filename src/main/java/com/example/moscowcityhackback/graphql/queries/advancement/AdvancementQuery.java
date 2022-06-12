package com.example.moscowcityhackback.graphql.queries.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.services.advancement.AdvancementService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdvancementQuery implements GraphQLQueryResolver {
    @Autowired
    private AdvancementService advancementService;

    public List<Advancement> getAdvancemenets() {
        return advancementService.getAll();
    }

    public Advancement getAdvancement(long id) {
        return advancementService.getById(id);
    }

}
