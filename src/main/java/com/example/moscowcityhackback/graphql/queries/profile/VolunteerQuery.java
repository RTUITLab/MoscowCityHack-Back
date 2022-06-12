package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.services.VolunteerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class VolunteerQuery implements GraphQLQueryResolver {
    @Autowired
    private VolunteerService volunteerService;

    public List<Volunteer> getVolunteers() {
        return volunteerService.getAll();
    }

    public Volunteer getVolunteer(long id) {
        return volunteerService.getById(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> prGetVolunteers() {
        return volunteerService.getAll();
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Volunteer prGetVolunteer(long id) {
        return volunteerService.getById(id);
    }
}
