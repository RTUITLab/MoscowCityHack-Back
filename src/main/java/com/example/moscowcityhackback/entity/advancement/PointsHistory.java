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
@Table(name = "points_history")
public class PointsHistory extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "advancement_id")
    private Advancement advancement;

    private Integer points;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private Long createdDate;
}