package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.advancement.AdvancementRepository;
import com.example.moscowcityhackback.services.AbstractService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvancementService extends AbstractService<Advancement, AdvancementRepository> {

    public AdvancementService(AdvancementRepository repository) {
        super(repository);
    }

    public Advancement getAdvancementsByUser(User user) {
        return repository.findByUser(user);
    }
}
