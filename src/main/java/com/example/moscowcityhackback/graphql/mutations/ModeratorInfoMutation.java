package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Moderator;
import com.example.moscowcityhackback.services.ModeratorInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PreAuthorize("hasAnyRole('MODERATOR', 'COMPANY')")
public class ModeratorInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private ModeratorInfoService ModeratorInfoService;

    public List<Moderator> createModerator(Moderator moderator) {
        return ModeratorInfoService.create(moderator);
    }

    public Moderator updateModerator(long id, Moderator moderator) {
        return ModeratorInfoService.update(id, moderator);
    }

    public List<Moderator> deleteModerator(long id) {
        return ModeratorInfoService.delete(id);
    }

    public List<Moderator> deleteModerators() {
        return ModeratorInfoService.deleteAll();
    }
}
