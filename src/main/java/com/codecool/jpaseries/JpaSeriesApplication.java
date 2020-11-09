package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Genre;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.Series;
import com.codecool.jpaseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class JpaSeriesApplication {

    @Autowired
    private SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaSeriesApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Series avatar = Series.builder()
                    .title("Avatar: The Last Airbender")
                    .genre(Genre.ACTION)
                    .genre(Genre.ADVENTURE)
                    .genre(Genre.ANIMATION)
                    .rating(9.2)
                    .build();

            Season water = Season.builder()
                    .series(avatar)
                    .title("Book One: Water")
                    .startDate(LocalDate.of(2005, 2, 21))
                    .build();

            Season earth = Season.builder()
                    .series(avatar)
                    .title("Book One: Earth")
                    .startDate(LocalDate.of(2006, 3, 17))
                    .build();

            Season fire = Season.builder()
                    .series(avatar)
                    .title("Book One: Fire")
                    .startDate(LocalDate.of(2007, 9, 21))
                    .build();

            avatar.setSeasons(List.of(water, earth, fire));

            seriesRepository.save(avatar);
        };
    }
}
