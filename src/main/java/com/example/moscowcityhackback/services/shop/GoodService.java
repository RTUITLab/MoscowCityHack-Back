package com.example.moscowcityhackback.services.shop;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.shop.Good;
import com.example.moscowcityhackback.repositories.profile.UserRepository;
import com.example.moscowcityhackback.repositories.shop.GoodRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService extends AbstractService<Good, GoodRepository> {
    private final UserRepository userRepository;

    @Autowired
    public GoodService(GoodRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }



    @Override
    public Good create(Good good) {
        good.setFavoriteUsers(persistedUsers(good.getFavoriteUsers()));
        return super.create(good);
    }

    @Override
    public Good update(long id, Good newE) {
        newE.setFavoriteUsers(persistedUsers(newE.getFavoriteUsers()));
        return super.update(id, newE);
    }

    private List<User> persistedUsers(List<User> users) {
        for(User user: users) {
            user.setId(userRepository.findByLogin(user.getLogin()).getId());
        }
        return users;
    }
}
