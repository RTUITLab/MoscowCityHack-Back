package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.Volunteer;
import com.example.moscowcityhackback.services.VolunteerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
