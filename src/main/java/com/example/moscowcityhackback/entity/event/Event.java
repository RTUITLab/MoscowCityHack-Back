package com.example.moscowcityhackback.entity.event;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.entity.profile.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @ElementCollection
    private List<String> taskDescription;
    @ElementCollection
    private List<String> requirements;
    @ElementCollection
    private List<String> facilities;
    private String photoUrl;
    private String email;
    private Integer currentAmount;
    private Integer maxAmount;
    private boolean online;
    @ManyToMany
    private List<User> participants;
    @OneToOne
    private User owner;
    @OneToMany
    private List<Direction> directions;
    @OneToMany
    private List<Tag> tags;
}
