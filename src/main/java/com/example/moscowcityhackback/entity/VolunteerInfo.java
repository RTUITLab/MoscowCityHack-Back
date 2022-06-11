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
public class VolunteerInfo extends AbstractEntity{
    private String name;
    private String surname;
    private Date birthDate;
    @OneToOne
    private UserInfo userInfo;

    public VolunteerInfo(Long id, String name, String surname, Date birthDate, UserInfo userInfo) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.userInfo = userInfo;
    }
}
