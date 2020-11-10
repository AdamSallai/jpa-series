package com.codecool.jpaseries.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long ID;

    private String title;
    private double rating;

    @ElementCollection
    @Singular
    @Enumerated(EnumType.STRING)
    private List<Genre> genres;

    @OneToMany(mappedBy = "series",cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Season> seasons;

    @Transient
    private int numberOfSeasons;

    public void countNumberOfSeasons() {
        this.numberOfSeasons = seasons.size();
    }
}
