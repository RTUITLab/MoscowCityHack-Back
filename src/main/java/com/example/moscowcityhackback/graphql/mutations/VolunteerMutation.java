package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.graphql.queries.CredentialsQuery;
import com.example.moscowcityhackback.services.UserService;
import com.example.moscowcityhackback.services.VolunteerService;
import com.example.moscowcityhackback.services.utils.UsernameFromTokenParser;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class VolunteerMutation implements GraphQLMutationResolver {
    private final UsernameFromTokenParser usernameParser;
    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerMutation(UsernameFromTokenParser usernameParser, VolunteerService volunteerService) {
        this.usernameParser = usernameParser;
        this.volunteerService = volunteerService;
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerService.create(volunteer);
    }

    public Volunteer updateVolunteer(long id, Volunteer volunteer) {
        return volunteerService.update(id, volunteer);
    }

    public List<Volunteer> deleteVolunteer(long id) {
        return volunteerService.delete(id);
    }

    public List<Volunteer> deleteVolunteers() {
        return volunteerService.deleteAll();
    }

    public CredentialsQuery.Credentials registerAuthorizeVol(Volunteer volunteer) {
        return volunteerService.createAndAuthorize(volunteer);
    }

    @PreAuthorize("isAnonymous()")
    public Volunteer prCreateVolunteer(Volunteer volunteer) {
        return volunteerService.create(volunteer);
    }

    @PreAuthorize("hasRole('VOLUNTEER')")
    @Transactional
    public Volunteer prUpdateVolunteer(long id, Volunteer volunteer, DataFetchingEnvironment env) throws Exception {
        return volunteerService.updateByIdAndUser(id, volunteer, usernameParser.getUserFromRequest(env));
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> prDeleteVolunteer(long id) {
        return volunteerService.delete(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> prDeleteVolunteers() {
        return volunteerService.deleteAll();
    }
}
