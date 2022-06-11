package com.example.moscowcityhackback.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserInfo extends AbstractEntity{
    private String login;
    private String password;

    @ManyToOne
    private Role role;

    public UserInfo(Long id, String login, String password, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
