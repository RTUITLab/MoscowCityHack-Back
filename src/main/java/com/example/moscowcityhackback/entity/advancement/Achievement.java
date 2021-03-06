package com.example.moscowcityhackback.entity.advancement;

import com.example.moscowcityhackback.entity.AbstractEntity;
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
@Table(name = "achievements")
public class Achievement extends AbstractEntity {
    private String name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Advancement> advancements;

    @OneToMany(mappedBy = "achievement", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AchievementHistory> history = new java.util.ArrayList<>();
}