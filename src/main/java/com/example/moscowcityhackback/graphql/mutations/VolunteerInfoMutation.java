package com.example.moscowcityhackback.graphql.mutations;

import com.example.moscowcityhackback.entity.VolunteerInfo;
import com.example.moscowcityhackback.services.VolunteerInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VolunteerInfoMutation implements GraphQLMutationResolver {
    @Autowired
    private VolunteerInfoService userService;

    public List<VolunteerInfo> createVolunteer(VolunteerInfo volunteer) {
        return userService.create(volunteer);
    }

    public VolunteerInfo updateVolunteer(long id, VolunteerInfo volunteer) {
        return userService.update(id, volunteer);
    }

    public List<VolunteerInfo> deleteVolunteer(long id) {
        return userService.delete(id);
    }

    public List<VolunteerInfo> deleteVolunteers() {
        return userService.deleteAll();
    }
}
