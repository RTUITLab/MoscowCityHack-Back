package com.example.moscowcityhackback.entity.shop;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.entity.profile.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart extends AbstractEntity {
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Good> goods;

    @OneToOne
    private User user;
}
