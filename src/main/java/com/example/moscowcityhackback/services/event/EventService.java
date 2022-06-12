package com.example.moscowcityhackback.services.event;

import com.example.moscowcityhackback.entity.event.Direction;
import com.example.moscowcityhackback.entity.event.Event;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.event.DirectionRepository;
import com.example.moscowcityhackback.repositories.event.EventRepository;
import com.example.moscowcityhackback.repositories.profile.UserRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Event> getParticipatedEvents(User user) {
        return repository.findAllByParticipantsContaining(user);
    }

    // TODO супер кринж костыль
    @Override
    public Event create(Event event) {
        List<Direction> directions = event.getDirections();
        List<Direction> updatedDirections = new ArrayList<>();
//        directions = directions.stream().map(d -> d.setId(directionRepository.findByName(d.getName()).getId())).collect(Collectors.toList());
        for(Direction direction: directions) {
            direction.setId(directionRepository.findByName(direction.getName()).getId());
            updatedDirections.add(direction);
        }
        event.setDirections(updatedDirections);

//        event.setOwner(userRepository.findByLogin(event.getOwner().getLogin()));

        List<User> users = event.getParticipants();
        List<User> updatedUsers = new ArrayList<>();
//        directions = directions.stream().map(d -> d.setId(directionRepository.findByName(d.getName()).getId())).collect(Collectors.toList());
        for(User user: users) {
            user.setId(userRepository.findByLogin(user.getLogin()).getId());
            updatedUsers.add(user);
        }
        event.setParticipants(updatedUsers);
        return super.create(event);
    }
}
