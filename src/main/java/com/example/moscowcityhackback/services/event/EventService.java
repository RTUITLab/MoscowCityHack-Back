package com.example.moscowcityhackback.services.event;

import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.searching.SearchRequest;
import com.example.moscowcityhackback.repositories.searching.SearchSpecification;
import com.example.moscowcityhackback.repositories.event.DirectionRepository;
import com.example.moscowcityhackback.repositories.event.EventRepository;
import com.example.moscowcityhackback.repositories.profile.UserRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService extends AbstractService<Event, EventRepository> {
    private final DirectionRepository directionRepository;
    private final UserRepository userRepository;

    @Autowired
    public EventService(EventRepository repository, DirectionRepository directionRepository, UserRepository userRepository) {
        super(repository);
        this.directionRepository = directionRepository;
        this.userRepository = userRepository;
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

    public List<Event> searchEvents(SearchRequest request){
        SearchSpecification<Event> specification = new SearchSpecification<>(request);
        Pageable pageable = SearchSpecification.getPageable(request.getPage(), request.getSize());
        return repository.findAll(specification, pageable).getContent();
    }

    public List<Event> getParticipatedEvents(User user) {
        return repository.findAllByParticipantsContaining(user);
    }

    @Override
    public Event create(Event event) {
        return super.create(event);
    }
}
