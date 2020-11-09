package com.codecool.jpaseries.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Long ID;

    @Column(nullable = false, unique = true)
    private Integer episodeNumber;

    private String title;
    private LocalDate releaseDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Season season;
}
