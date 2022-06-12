package com.example.moscowcityhackback.repositories.advancement;

import com.example.moscowcityhackback.entity.advancement.Advancement;
import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface AdvancementRepository extends CommonRepository<Advancement> {
    Advancement findByUser(User user);
}
