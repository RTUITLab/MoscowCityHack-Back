package com.example.moscowcityhackback.entity.advancement;

import com.example.moscowcityhackback.entity.AbstractEntity;
import com.example.moscowcityhackback.entity.profile.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "company")
public class Advancement extends AbstractEntity {
    @OneToOne
    private User user;

    private Integer level;
    private Integer points;

    @OneToMany(mappedBy = "advancement", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PointsHistory> pointsHistory = new java.util.ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Achievement> achievements;
    private Integer exp;


}
