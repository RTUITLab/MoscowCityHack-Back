package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Volunteer;
import com.example.moscowcityhackback.services.VolunteerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VolunteerMutation implements GraphQLMutationResolver {
    @Autowired
    private VolunteerService volunteerService;

    public List<Volunteer> createVolunteer(Volunteer volunteer) {
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
}
