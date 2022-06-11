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
@Table(name = "volunteer")
public class Volunteer extends AbstractEntity{
    private String name;
    private String surname;
    private LocalDate birthDate;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public Volunteer(Long id, String name, String surname, LocalDate birthDate, User user) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user = user;
    }
}
