package com.example.moscowcityhackback.entity.profile;

import com.example.moscowcityhackback.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(unique = true)
    private String login;
    private String password;

    @ManyToOne
    private Role role;

    public User(Long id, String login, String password, Role role) {
        super(id);
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
