package cinema.shows.repos;

import cinema.shows.entities.Movie;
import cinema.shows.entities.MoviePlaying;
import cinema.shows.entities.MoviePlayingPK;
import cinema.shows.entities.Theater;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class MoviePlayingRepoTest {
    @Autowired
    MoviePlayingRepo moviePlayingRepo;
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    TheaterRepo theaterRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @AfterEach
    private void cleanDB() {
        categoryRepo.deleteAll();
        movieRepo.deleteAll();
        theaterRepo.deleteAll();
        moviePlayingRepo.deleteAll();
    }

    @Test
    @Sql("/createCategory.sql")
    @Sql("/createMovie.sql")
    @Sql("/createTheater.sql")
    public void testAddingMovieInTheater() {
        MoviePlayingPK moviePlayingPK = new MoviePlayingPK(1,1);
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        MoviePlaying moviePlaying = new MoviePlaying(moviePlayingPK, dateStarts, dateEnds);
        assertEquals(0, moviePlayingRepo.count());
        moviePlayingRepo.save(moviePlaying);
        assertEquals(1, moviePlayingRepo.count());
        moviePlayingRepo.delete(moviePlaying);
        assertEquals(1,movieRepo.count());
        assertEquals(1,theaterRepo.count());
    }

    @Test
    @Sql("/createCategory.sql")
    @Sql("/createMovie.sql")
    @Sql("/createTheater.sql")
    public void testGettingMovieForDate() {
        MoviePlayingPK moviePlayingPK = new MoviePlayingPK(1,1);
        Date wrongDate = Date.valueOf("2021-11-10");
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        MoviePlaying moviePlaying = new MoviePlaying(moviePlayingPK, dateStarts, dateEnds);
        moviePlayingRepo.save(moviePlaying);
        assertEquals(0, moviePlayingRepo.getAllByDateStarts(wrongDate).size());
        assertEquals(1, moviePlayingRepo.getAllByDateStarts(dateStarts).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsBetween(dateStarts,dateEnds).size());
        moviePlayingRepo.save(moviePlaying);
        assertEquals(1, moviePlayingRepo.count());
        moviePlayingRepo.delete(moviePlaying);
        assertEquals(1,movieRepo.count());
        assertEquals(1,theaterRepo.count());
    }

}