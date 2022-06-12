package com.example.moscowcityhackback.services.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.repositories.advancement.AdvancementRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AdvancementService extends AbstractService<Advancement, AdvancementRepository> {
    public AdvancementService(AdvancementRepository repository) {
        super(repository);
    }
}
