package com.example.moscowcityhackback.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "moderators")
public class Moderator extends AbstractEntity{
    private String name;
    private String surname;
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Moderator(Long id, String name, String surname, LocalDate birthDate, User user) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user = user;
    }
}
