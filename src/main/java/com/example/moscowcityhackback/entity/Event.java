package com.example.moscowcityhackback.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event extends AbstractEntity {
    private String title;
    private String region;
    private String address;
    private Timestamp beginTime;
    private Timestamp endTime;
    private String taskDescription;
    private String requirements;
    private String facilities;
    private String photoUrl;
    private String email;
    @OneToMany
    private List<Direction> directions;
    @OneToMany
    private List<Tag> tags;
}
