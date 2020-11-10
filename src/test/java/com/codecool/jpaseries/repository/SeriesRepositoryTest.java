package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Episode;
import com.codecool.jpaseries.entity.Season;
import com.codecool.jpaseries.entity.Series;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class SeriesRepositoryTest {
    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void episodesAndSeasonsArePersistedAndDeletedWithSeries() {
        Series series = Series.builder()
                .title("Series")
                .build();

        Season season = Season.builder()
                .title("Season")
                .build();

        Episode episode1 = Episode.builder()
                .episodeNumber(1)
                .title("Example episode 1")
                .season(season)
                .build();

        Episode episode2 = Episode.builder()
                .episodeNumber(2)
                .title("Example episode 2")
                .season(season)
                .build();

        season.setEpisodes(List.of(episode1, episode2));
        series.setSeasons(List.of(season));
        seriesRepository.save(series);

        List<Episode> episodes = episodeRepository.findAll();
        List<Season> seasons = seasonRepository.findAll();
        assertEquals(2, episodes.size());
        assertEquals(1, seasons.size());

        seriesRepository.deleteAll();
        episodes = episodeRepository.findAll();
        seasons = seasonRepository.findAll();
        assertEquals(0, episodes.size());
        assertEquals(0, seasons.size());
    }

}