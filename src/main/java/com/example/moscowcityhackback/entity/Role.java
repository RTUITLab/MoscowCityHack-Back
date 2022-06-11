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
@Table(name = "roles")
public class Role extends AbstractEntity{
    private String name;

    public Role(Long id, String name) {
        super(id);
        this.name = name;
    }
}
