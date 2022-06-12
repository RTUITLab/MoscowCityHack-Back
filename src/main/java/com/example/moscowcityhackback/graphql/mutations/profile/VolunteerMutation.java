package com.example.moscowcityhackback.graphql.mutations.profile;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.graphql.queries.profile.CredentialsQuery;
import com.example.moscowcityhackback.services.profile.VolunteerService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class VolunteerMutation implements GraphQLMutationResolver {
    private final TokenParser usernameParser;
    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerMutation(TokenParser usernameParser, VolunteerService volunteerService) {
        this.usernameParser = usernameParser;
        this.volunteerService = volunteerService;
    }

    @PreAuthorize("isAnonymous()")
    public CredentialsQuery.Credentials registerAuthorizeVol(Volunteer volunteer) {
        return volunteerService.createAndAuthorize(volunteer);
    }

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerService.create(volunteer);
    }

    @PreAuthorize("hasRole('VOLUNTEER')")
    @Transactional
    public Volunteer updateVolunteer(long id, Volunteer volunteer, DataFetchingEnvironment env) throws Exception {
        return volunteerService.updateByIdAndUser(id, volunteer, usernameParser.getUserFromRequest(env));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> deleteVolunteer(long id) {
        return volunteerService.delete(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> deleteVolunteers() {
        return volunteerService.deleteAll();
    }
}
