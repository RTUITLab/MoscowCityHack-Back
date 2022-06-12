package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.services.ModeratorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PreAuthorize("hasAnyRole('MODERATOR', 'COMPANY')")
public class ModeratorMutation implements GraphQLMutationResolver {
    @Autowired
    private ModeratorService ModeratorService;

    public Moderator createModerator(Moderator moderator) {
        return ModeratorService.create(moderator);
    }

    public Moderator updateModerator(long id, Moderator moderator) {
        return ModeratorService.update(id, moderator);
    }

    public List<Moderator> deleteModerator(long id) {
        return ModeratorService.delete(id);
    }

    public List<Moderator> deleteModerators() {
        return ModeratorService.deleteAll();
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator prCreateModerator(Moderator moderator) {
        return ModeratorService.create(moderator);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator prUpdateModerator(long id, Moderator moderator) {
        return ModeratorService.update(id, moderator);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> prDeleteModerator(long id) {
        return ModeratorService.delete(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> prDeleteModerators() {
        return ModeratorService.deleteAll();
    }
}
