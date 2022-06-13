package com.example.moscowcityhackback.graphql.queries.shop;

import com.example.moscowcityhackback.entity.shop.Good;
import com.example.moscowcityhackback.services.shop.GoodService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodQuery implements GraphQLQueryResolver {
    private final GoodService goodService;

    @Autowired
    public GoodQuery(GoodService goodService) {
        this.goodService = goodService;
    }

//    @PreAuthorize("isAuthenticated()")
    public Good getGood(long id) {
        return goodService.getById(id);
    }

//    @PreAuthorize("isAuthenticated()")
    public List<Good> getGoods() {
        return goodService.getAll();
    }
}
