package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.advancement.AdvancementRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AdvancementService extends AbstractService<Advancement, AdvancementRepository> {

    public AdvancementService(AdvancementRepository repository) {
        super(repository);
    }

    public Advancement getAdvancementByUser(User user) {
        return repository.findByUser(user);
    }

    public Advancement updateAdvancementByUser(Advancement advancement, User user) {
        advancement.setId(repository.findByUser(user).getId());
        repository.save(advancement);
        return repository.findByUser(user);
    }
}
