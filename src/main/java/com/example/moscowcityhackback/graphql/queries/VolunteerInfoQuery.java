package com.example.moscowcityhackback.graphql.queries;

import com.example.moscowcityhackback.entity.VolunteerInfo;
import com.example.moscowcityhackback.services.VolunteerInfoService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VolunteerInfoQuery implements GraphQLQueryResolver {
    @Autowired
    private VolunteerInfoService volunteerInfoService;

    public List<VolunteerInfo> getVolunteers() {
        return volunteerInfoService.getAll();
    }

    public VolunteerInfo getVolunteer(long id) {
        return volunteerInfoService.getById(id);
    }
}
