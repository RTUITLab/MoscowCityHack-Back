package com.example.moscowcityhackback.entity.event;

import com.example.moscowcityhackback.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "directions")
public class Direction extends AbstractEntity {
    private String name;
    @ManyToMany
    private List<Event> event;
}
