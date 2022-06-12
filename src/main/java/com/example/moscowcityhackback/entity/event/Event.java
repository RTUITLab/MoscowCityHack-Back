package com.example.moscowcityhackback.entity.event;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.entity.profile.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
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
    private OffsetDateTime beginTime;
    private OffsetDateTime endTime;

    @ElementCollection()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> taskDescription;

    @ElementCollection()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> requirements;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
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

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Direction> directions;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Tag> tags;
}
