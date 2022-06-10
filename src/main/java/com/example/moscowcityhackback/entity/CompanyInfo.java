package com.example.moscowcityhackback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CompanyInfo extends AbstractEntity{
    private String name;
    private String address;
    @OneToOne
    private User user;

    public CompanyInfo(Long id, String name, String address, User user) {
        super(id);
        this.name = name;
        this.address = address;
        this.user = user;
    }
}
