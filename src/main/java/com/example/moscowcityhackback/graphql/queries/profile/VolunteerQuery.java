package com.example.moscowcityhackback.graphql.queries.profile;

import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.services.profile.VolunteerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VolunteerQuery implements GraphQLQueryResolver {
    @Autowired
    private VolunteerService volunteerService;

    public List<Volunteer> unprGetVolunteers() {
        return volunteerService.getAll();
    }

    public Volunteer unprGetVolunteer(long id) {
        return volunteerService.getById(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public List<Volunteer> getVolunteers() {
        return volunteerService.getAll();
    }

    @PreAuthorize("hasRole('MODERATOR')")
    public Volunteer getVolunteer(long id) {
        return volunteerService.getById(id);
    }
}
