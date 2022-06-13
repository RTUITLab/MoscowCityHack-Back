package com.example.moscowcityhackback.graphql.mutations.shop;

import com.example.moscowcityhackback.entity.shop.Cart;
import com.example.moscowcityhackback.services.shop.CartService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMutation implements GraphQLMutationResolver {
    private final CartService cartService;
    private final TokenParser tokenParser;

    @Autowired
    public CartMutation(CartService cartService, TokenParser tokenParser) {
        this.cartService = cartService;
        this.tokenParser = tokenParser;
    }

    public Cart updateCartByToken(Cart cart, DataFetchingEnvironment env) {
        return cartService.updateCartByUser(tokenParser.getUserFromRequest(env), cart);
    }
}
