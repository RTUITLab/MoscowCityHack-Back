package com.example.moscowcityhackback.repositories.profile;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.profile.Volunteer;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface VolunteerRepository extends CommonRepository<Volunteer> {
    Volunteer findByIdAndUser(long id, User user);
    Volunteer findByUser(User user);
}
