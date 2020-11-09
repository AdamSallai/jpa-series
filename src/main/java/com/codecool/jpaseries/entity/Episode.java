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

    private String title;
    private LocalDate releaseDate;
    private double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Season season;
}
