package cinema.shows.repos;

import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MovieAndActorReposTest {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    ActorRepo actorRepo;

    @AfterEach
    public void cleanDB() {
        movieRepo.deleteAll();
        actorRepo.deleteAll();
    }

    @Test
    @Sql("/createCategory.sql")
    @Sql("/createMovie.sql")
    public void testBidirectionalRel() {
        Actor actorOne = new Actor("Al", "Pacino");
        actorRepo.save(actorOne);
        Actor actorOneSaved = actorRepo.getById(1);
        Actor actorTwo = new Actor("Robert", "DeNiro");
        actorRepo.save(actorTwo);
        Actor actorTwoSaved = actorRepo.getById(2);
        Movie movieOne = movieRepo.getById(1);
        List<Actor> actors = new ArrayList<>(Arrays.asList(actorOneSaved,actorTwoSaved));
        Set<Actor> actorSet = new HashSet(actors);
        movieOne.getActorSet().addAll(Arrays.asList(actorOneSaved,actorTwoSaved));
        movieRepo.save(movieOne);
        System.out.println(movieRepo.getById(1).getActorSet());
        assertEquals(2, movieRepo.getById(1).getActorSet().size());
        assertEquals(1, actorRepo.getById(1).getMovieSet().size());
        assertEquals(1, actorRepo.getById(2).getMovieSet().size());
        Actor actorThree = new Actor(3,"Keanu","Reeves");
        Actor actorThreeSaved = actorRepo.save(actorThree);
        Movie movie = movieRepo.getById(1);
        movie.getActorSet().add(actorThreeSaved);
        Movie movieSavedTwo = movieRepo.save(movie);
        assertEquals(3, movieSavedTwo.getActorSet().size());
    }
}