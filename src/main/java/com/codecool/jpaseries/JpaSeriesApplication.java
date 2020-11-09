package com.codecool.jpaseries;

import com.codecool.jpaseries.entity.Episode;
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
import java.util.ArrayList;
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

            // first season
            water.setEpisodes(List.of(
                    Episode.builder()
                            .title("The boy in the Iceberg")
                            .episodeNumber(1)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 2, 21))
                            .build(),
                    Episode.builder()
                            .title("The Avatar Returns")
                            .episodeNumber(2)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 2, 21))
                            .build(),
                    Episode.builder()
                            .title("The Southern Air Temple")
                            .episodeNumber(3)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 2, 25))
                            .build(),
                    Episode.builder()
                            .title("The Warriors of Kyoshi")
                            .episodeNumber(4)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 3, 4))
                            .build(),
                    Episode.builder()
                            .title("The King of Omashu")
                            .episodeNumber(5)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 3, 18))
                            .build(),
                    Episode.builder()
                            .title("Imprisoned")
                            .episodeNumber(6)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 3, 25))
                            .build(),
                    Episode.builder()
                            .title("The Spirit World (Winter Solstice, Part 1)")
                            .episodeNumber(7)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 4, 8))
                            .build(),
                    Episode.builder()
                            .title("Avatar Roku (Winter Solstice, Part 2)")
                            .episodeNumber(8)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 4, 15))
                            .build(),
                    Episode.builder()
                            .title("The Waterbending Scroll")
                            .episodeNumber(9)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 4, 29))
                            .build(),
                    Episode.builder()
                            .title("Jet")
                            .episodeNumber(10)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 5, 6))
                            .build(),
                    Episode.builder()
                            .title("The Great Divide")
                            .episodeNumber(11)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 5, 20))
                            .build(),
                    Episode.builder()
                            .title("The Storm")
                            .episodeNumber(12)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 6, 3))
                            .build(),
                    Episode.builder()
                            .title("The Blue Spirit")
                            .episodeNumber(13)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 6, 17))
                            .build(),
                    Episode.builder()
                            .title("The Fortuneteller")
                            .episodeNumber(14)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 9, 23))
                            .build(),
                    Episode.builder()
                            .title("Bato of the Water Tribe")
                            .episodeNumber(15)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 10, 7))
                            .build(),
                    Episode.builder()
                            .title("The Deserter")
                            .episodeNumber(16)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 10, 21))
                            .build(),
                    Episode.builder()
                            .title("The Northern Air Temple")
                            .episodeNumber(17)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 11, 4))
                            .build(),
                    Episode.builder()
                            .title("The Waterbending Master")
                            .episodeNumber(18)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 11, 18))
                            .build(),
                    Episode.builder()
                            .title("The Siege of the North Part 1")
                            .episodeNumber(19)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 12, 2))
                            .build(),
                    Episode.builder()
                            .title("The Siege of the North Part 2")
                            .episodeNumber(20)
                            .season(water)
                            .releaseDate(LocalDate.of(2005, 12, 2))
                            .build()));

            seriesRepository.save(avatar);
        };
    }
}
