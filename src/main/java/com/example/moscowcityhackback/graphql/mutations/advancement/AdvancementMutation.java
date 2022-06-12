package com.example.moscowcityhackback.graphql.mutations.advancement;

import org.springframework.stereotype.Component;
import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.services.advancement.AdvancementService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class AdvancementMutation implements GraphQLMutationResolver {
    @Autowired
    private AdvancementService advancementService;

    public Advancement createAdvancement(Advancement advancement) {
        return advancementService.create(advancement);
    }

    public Advancement updateAdvancement(long id, Advancement advancement) {
        return advancementService.update(id, advancement);
    }

    public List<Advancement> deleteAdvancement(long id) {
        return advancementService.delete(id);
    }

    public List<Advancement> deleteAdvancements() {
        return advancementService.deleteAll();
    }
}
