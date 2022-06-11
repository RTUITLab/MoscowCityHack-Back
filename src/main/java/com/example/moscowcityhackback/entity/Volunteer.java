package com.example.moscowcityhackback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "volunteer")
public class Volunteer extends AbstractEntity{
    private String name;
    private String surname;
    private Date birthDate;
    @OneToOne
    private User user;

    public Volunteer(Long id, String name, String surname, Date birthDate, User user) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user = user;
    }
}
