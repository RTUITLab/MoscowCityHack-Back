package com.example.moscowcityhackback.services.shop;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.shop.Cart;
import com.example.moscowcityhackback.repositories.profile.UserRepository;
import com.example.moscowcityhackback.repositories.shop.CartRepository;
import com.example.moscowcityhackback.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService extends AbstractService<Cart, CartRepository> {
    private final UserRepository userRepository;

    @Autowired
    public CartService(CartRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
    }

    public Cart getCartByUser(User user) {
        return repository.findByUser(user);
    }

    public Cart updateCartByUser(User user, Cart cart) {
        cart.setUser(userRepository.findByLogin(user.getLogin()));
        repository.save(cart);
        return repository.findByUser(user);
    }
}
