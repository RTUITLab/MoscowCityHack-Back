package com.example.moscowcityhackback.services;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
