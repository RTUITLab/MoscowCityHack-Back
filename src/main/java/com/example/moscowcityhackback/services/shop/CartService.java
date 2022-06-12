package com.example.moscowcityhackback.services.shop;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.shop.Cart;
import com.example.moscowcityhackback.repositories.shop.CartRepository;
import com.example.moscowcityhackback.services.AbstractService;
import com.example.moscowcityhackback.services.utils.TokenParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends AbstractService<Cart, CartRepository> {

    public CartService(CartRepository repository) {
        super(repository);
    }

    public Cart getCartByUser(User user) {
        return repository.findByUser(user);
    }

    public Cart updateCartByUser(User user, Cart cart) {
        cart.setId(repository.findByUser(user).getId());
        repository.save(cart);
        return repository.findByUser(user);
    }
}
