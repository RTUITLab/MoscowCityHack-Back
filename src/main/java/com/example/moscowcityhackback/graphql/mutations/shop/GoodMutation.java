package com.example.moscowcityhackback.graphql.mutations.shop;

import com.example.moscowcityhackback.entity.shop.Good;
import com.example.moscowcityhackback.services.shop.GoodService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodMutation implements GraphQLMutationResolver {
    private final GoodService goodService;

    @Autowired
    public GoodMutation(GoodService goodService) {
        this.goodService = goodService;
    }

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Good createGood(Good good) {
        return goodService.create(good);
    }

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public Good updateGood(long id, Good good) {
        return goodService.update(id, good);
    }

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<Good> deleteGood(long id) {
        return goodService.delete(id);
    }

    @PreAuthorize("hasAnyRole('MODERATOR')")
    public List<Good> deleteGoods() {
        return goodService.deleteAll();
    }
}
