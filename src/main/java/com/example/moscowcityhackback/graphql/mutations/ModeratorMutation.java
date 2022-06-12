package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.profile.Moderator;
import com.example.moscowcityhackback.graphql.queries.CredentialsQuery;
import com.example.moscowcityhackback.services.ModeratorService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PreAuthorize("hasAnyRole('MODERATOR')")
public class ModeratorMutation implements GraphQLMutationResolver {
    @Autowired
    private ModeratorService moderatorService;

    public Moderator createModerator(Moderator moderator) {
        return moderatorService.create(moderator);
    }

    public Moderator updateModerator(long id, Moderator moderator) {
        return moderatorService.update(id, moderator);
    }

    public List<Moderator> deleteModerator(long id) {
        return moderatorService.delete(id);
    }

    public List<Moderator> deleteModerators() {
        return moderatorService.deleteAll();
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator prCreateModerator(Moderator moderator) {
        return moderatorService.create(moderator);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Moderator prUpdateModerator(long id, Moderator moderator) {
        return moderatorService.update(id, moderator);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> prDeleteModerator(long id) {
        return moderatorService.delete(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Moderator> prDeleteModerators() {
        return moderatorService.deleteAll();
    }
    
    public CredentialsQuery.Credentials registerAuthorizeMod(Moderator moderator) {
        return moderatorService.createAndAuthorize(moderator);
    }
}
