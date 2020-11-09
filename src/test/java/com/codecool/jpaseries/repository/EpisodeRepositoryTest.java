package com.codecool.jpaseries.repository;

import com.codecool.jpaseries.entity.Episode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class EpisodeRepositoryTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void saveOneEpisode() {
        Episode episode = Episode.builder()
                .episodeNumber(1)
                .title("Example episode")
                .build();

        episodeRepository.save(episode);

        assertEquals(episode.getTitle(), episodeRepository.findAll().get(0).getTitle());
    }

    @Test
    public void saveUniqueFieldTwiceThrowsDataIntegrityViolationException() {
        Episode episode1 = Episode.builder()
                .episodeNumber(1)
                .title("Example episode one")
                .build();
        Episode episode2 = Episode.builder()
                .episodeNumber(1)
                .title("Example episode two")
                .build();

        episodeRepository.save(episode1);

        assertThrows(DataIntegrityViolationException.class, () -> {
            episodeRepository.saveAndFlush(episode2);
        });

    }
}