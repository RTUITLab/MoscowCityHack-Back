package com.example.moscowcityhackback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "companies")
public class Company extends AbstractEntity{
    private String name;
    private String photoUrl;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Company(Long id, String name, String address, User user) {
        super(id);
        this.name = name;
        this.user = user;
    }

    public Company(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
