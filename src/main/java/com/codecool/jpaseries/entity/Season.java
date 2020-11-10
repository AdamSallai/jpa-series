package com.codecool.jpaseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Season {
    @Id
    @GeneratedValue
    private Long ID;

    private String title;
    private LocalDate startDate;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Episode> episodes;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Series series;

    @Transient
    private int numberOfEpisodes;

    public void countNumberOfEpisodes() {
        this.numberOfEpisodes = episodes.size();
    }
}
