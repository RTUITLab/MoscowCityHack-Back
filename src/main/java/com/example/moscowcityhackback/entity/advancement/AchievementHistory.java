package com.example.moscowcityhackback.entity.advancement;

import com.example.moscowcityhackback.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "achievements_history")
public class AchievementHistory extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Long createdDate;

}