package com.example.moscowcityhackback.graphql.queries.shop;

import com.example.moscowcityhackback.entity.shop.Cart;
import com.example.moscowcityhackback.services.shop.CartService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartQuery implements GraphQLQueryResolver {
    private final CartService cartService;
    private final TokenParser tokenParser;

    @Autowired
    public CartQuery(CartService cartService, TokenParser tokenParser) {
        this.cartService = cartService;
        this.tokenParser = tokenParser;
    }

    public Cart getCartByToken(DataFetchingEnvironment env) {
        return cartService.getCartByUser(tokenParser.getUserFromRequest(env));
    }

    public Cart updateCartByToken(Cart cart, DataFetchingEnvironment env) {
        return cartService.updateCartByUser(tokenParser.getUserFromRequest(env), cart);
    }
}
