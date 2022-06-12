package com.example.moscowcityhackback.services.shop;

import com.example.moscowcityhackback.entity.shop.Good;
import com.example.moscowcityhackback.repositories.shop.GoodRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class GoodService extends AbstractService<Good, GoodRepository> {
    public GoodService(GoodRepository repository) {
        super(repository);
    }
}
