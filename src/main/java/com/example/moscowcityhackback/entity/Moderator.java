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
@Table(name = "moderators")
public class Moderator extends AbstractEntity{
    private String name;
    private String surname;
    private Date birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Moderator(Long id, String name, String surname, Date birthDate, User user) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user = user;
    }
}
