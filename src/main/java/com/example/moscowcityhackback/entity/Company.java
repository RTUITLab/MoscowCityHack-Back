package com.example.moscowcityhackback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company")
public class Company extends AbstractEntity{
    private String name;
    private String address;
    @OneToOne
    private User user;

    public Company(Long id, String name, String address, User user) {
        super(id);
        this.name = name;
        this.address = address;
        this.user = user;
    }
}
