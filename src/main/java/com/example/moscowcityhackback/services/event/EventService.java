package com.example.moscowcityhackback.services.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.event.EventRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService extends AbstractService<Event, EventRepository> {
    public EventService(EventRepository repository) {
        super(repository);
    }

    public List<Event> getAllByOwner(User owner) {
        return repository.findByOwner(owner);
    }

    public Event getByIdAndOwner(long id, User owner) {
        return repository.findByIdAndOwner(id, owner);
    }

    public List<Event> deleteByIdAndOwner(long id, User owner) {
        repository.deleteByIdAndOwner(id, owner);
        return repository.findAllByOwner(owner);
    }

    public List<Event> deleteAllByOwner(User owner) {
        repository.deleteAllByOwner(owner);
        return repository.findAllByOwner(owner);
    }

}