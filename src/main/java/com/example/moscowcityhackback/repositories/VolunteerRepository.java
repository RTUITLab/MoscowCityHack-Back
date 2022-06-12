package com.example.moscowcityhackback.repositories;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.profile.Volunteer;

public interface VolunteerRepository extends CommonRepository<Volunteer> {
    Volunteer findByIdAndUser(long id, User user);
}
