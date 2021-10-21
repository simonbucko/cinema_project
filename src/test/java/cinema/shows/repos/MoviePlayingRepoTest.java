package cinema.shows.repos;

import cinema.shows.entities.Movie;
import cinema.shows.entities.MoviePlaying;
import cinema.shows.entities.Theater;
import cinema.shows.testUtils.TestDataMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
    @Autowired
    ShowRepo showRepo;

    int theaterId;
    int categoryId;
    int movieId;
    @BeforeEach
    public void initDate() {
        showRepo.deleteAll();
        moviePlayingRepo.deleteAll();
        movieRepo.deleteAll();
        categoryRepo.deleteAll();
        theaterRepo.deleteAll();
        theaterId = TestDataMaker.createTheater(theaterRepo);
        categoryId = TestDataMaker.createCategory(categoryRepo);
        movieId = TestDataMaker.createMovie(movieRepo,categoryId);
    }

    @Test
    public void testAddingMoviePlayingInTheater() {
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        Movie movie = movieRepo.getById(movieId);
        Theater theater = theaterRepo.getById(theaterId);
        MoviePlaying moviePlaying = new MoviePlaying(dateStarts, dateEnds, movie.getId(), theater);
        assertEquals(0, moviePlayingRepo.count());
        moviePlayingRepo.save(moviePlaying);
        assertEquals(1, moviePlayingRepo.count());
        moviePlayingRepo.delete(moviePlaying);
        assertEquals(1,movieRepo.count());
        assertEquals(1,theaterRepo.count());
    }

    @Test
    public void testGettingMoviePlayingForASpecificDate() {
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        Movie movie = movieRepo.getById(movieId);
        Theater theater = theaterRepo.getById(theaterId);
        MoviePlaying moviePlaying = new MoviePlaying(dateStarts, dateEnds, movie.getId(), theater);
        Date beforeStartDate = Date.valueOf("2021-11-10");
        Date betweenPlayingDates = Date.valueOf("2021-11-16");
        Date afterEndingDate = Date.valueOf("2021-11-23");
        moviePlayingRepo.save(moviePlaying);
        assertEquals(0, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(beforeStartDate, beforeStartDate).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts, dateStarts).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(betweenPlayingDates, betweenPlayingDates).size());
        assertEquals(0, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(afterEndingDate, afterEndingDate).size());
    }

    @Test
    public void testGettingMoviePlayingForAPairOFDates() {
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        Movie movie = movieRepo.getById(movieId);
        Theater theater = theaterRepo.getById(theaterId);
        MoviePlaying moviePlaying = new MoviePlaying(dateStarts, dateEnds, movie.getId(), theater);
        Date beforeStartDate = Date.valueOf("2021-11-10");
        Date betweenPlayingDates = Date.valueOf("2021-11-16");
        moviePlayingRepo.save(moviePlaying);
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,dateEnds).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(beforeStartDate,dateEnds).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(beforeStartDate,betweenPlayingDates).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(beforeStartDate,dateStarts).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,betweenPlayingDates).size());
        assertEquals(1, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(betweenPlayingDates,dateEnds).size());
        assertEquals(0, moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,beforeStartDate).size());
    }

}