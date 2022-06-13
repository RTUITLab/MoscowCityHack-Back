package com.example.moscowcityhackback.graphql.mutations.profile;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.services.profile.ModeratorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@PreAuthorize("hasAnyRole('MODERATOR')")
public class ModeratorMutation implements GraphQLMutationResolver {
    @Autowired
    private ModeratorService moderatorService;

//    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator createModerator(Moderator moderator) {
        return moderatorService.create(moderator);
    }

//    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator updateModerator(long id, Moderator moderator) {
        return moderatorService.update(id, moderator);
    }

//    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> deleteModerator(long id) {
        return moderatorService.delete(id);
    }

//    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> deleteModerators() {
        return moderatorService.deleteAll();
    }
}
