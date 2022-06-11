package com.example.moscowcityhackback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {
    @OneToMany
    private List<Direction> directions;
    private String name;
    private String region;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String desc;
    private String requirements;
    private String facilities;
    private String imageUrl;
    @OneToMany
    private List<Tag> tags;
    private String email;
}
