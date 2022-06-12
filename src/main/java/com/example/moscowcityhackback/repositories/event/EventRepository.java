package com.example.moscowcityhackback.repositories.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.CommonRepository;

import java.util.List;

public interface EventRepository extends CommonRepository<Event> {
    List<Event> findByOwner(User owner);
    Event findByIdAndOwner(long id, User owner);
    void deleteByIdAndOwner(long id, User owner);
    void deleteAllByOwner(User owner);
    List<Event> findAllByOwner(User owner);
    List<Event> findAllByParticipantsContaining(User user);
}
