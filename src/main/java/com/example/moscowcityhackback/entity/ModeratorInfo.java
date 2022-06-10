package com.example.moscowcityhackback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ModeratorInfo extends AbstractEntity{
    private String name;
    private String surname;
    private Date birthDate;
    @OneToOne
    private User user;

    public ModeratorInfo(Long id, String name, String surname, Date birthDate, User user) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.user = user;
    }
}
