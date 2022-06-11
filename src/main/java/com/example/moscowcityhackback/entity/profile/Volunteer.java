package com.example.moscowcityhackback.entity.profile;

import com.example.moscowcityhackback.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "volunteers")
public class Volunteer extends AbstractEntity {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String photoUrl;
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
