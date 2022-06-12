package com.example.moscowcityhackback.entity.shop;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.entity.profile.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Good extends AbstractEntity {
    private String name;
    private String desc;
    private Integer price;
    private String imgSrc;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> favoriteUsers;
}
