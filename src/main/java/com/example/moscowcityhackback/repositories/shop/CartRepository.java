package com.example.moscowcityhackback.repositories.shop;

import com.example.moscowcityhackback.entity.profile.User;
import com.example.moscowcityhackback.entity.shop.Cart;
import com.example.moscowcityhackback.repositories.CommonRepository;

public interface CartRepository extends CommonRepository<Cart> {
    Cart findByUser(User user);
}
