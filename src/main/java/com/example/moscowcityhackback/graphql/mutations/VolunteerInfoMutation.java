package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.Volunteer;
import com.example.moscowcityhackback.services.VolunteerInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VolunteerInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private VolunteerInfoService userService;

    public List<Volunteer> createVolunteer(Volunteer volunteer) {
        return userService.create(volunteer);
    }

    public Volunteer updateVolunteer(long id, Volunteer volunteer) {
        return userService.update(id, volunteer);
    }

    public List<Volunteer> deleteVolunteer(long id) {
        return userService.delete(id);
    }

    public List<Volunteer> deleteVolunteers() {
        return userService.deleteAll();
    }
}
