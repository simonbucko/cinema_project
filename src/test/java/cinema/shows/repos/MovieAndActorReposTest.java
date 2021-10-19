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
//    @Sql("/createActor.sql")
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
//        // CHECK the sql scripts worked
//        Actor actor = actorRepo.save(new Actor(1,"Al","Pacino"));
//        assertEquals(1, actorRepo.count());
//        assertEquals(1, movieRepo.count());
//        // getting one actor from the db
//        Actor actorOne = actorRepo.getById(1);
//        // getting the movie from the db
//        Movie movieOne = movieRepo.getById(1);
//        // SET the movie's actor set
//        List<Actor> actors = new ArrayList<>(Arrays.asList(actorOne));
//        movieOne.setActorSet(new HashSet(actors));
//        // CHECK there are no actors for that movie yet since we didn't save the movie yet
//        assertEquals(0, movieRepo.getById(1).getActorSet().size());
//        // SAVE the movie
//        movieRepo.save(movieOne);
//        // CHECK the actor set in the movie
//        assertEquals(1, movieRepo.getById(1).getActorSet().size());
//        // Querying the actor side we should get a list of the movies he's playing in
//        assertEquals(1, actorRepo.getById(1).getMovieSet().size());
//        // create new actor
//        Actor actorTwo = new Actor("Robert","De Niro");
//        // actor yet not saved
//        Actor actorTwoSaved = actorRepo.save(actorTwo);
////        assertEquals(1, actorRepo.count());
//        Movie movieOneB = movieRepo.getById(1);
//        movieOneB.getActorSet().add(actorTwoSaved);
////        movieOneB.addActor(actorTwoSaved);
//        movieRepo.save(movieOneB);
//        System.out.println(movieRepo.getById(1).getActorSet());
//        // CHECK if the actor was added to the movie list
//        assertEquals(2, movieRepo.getById(1).getActorSet().size());
//        // CHECK if the actor was saved
//        assertEquals(2, actorRepo.count());
//        // Querying the actor side we should get a list of the movies he's playing in
//        assertEquals(1, actorRepo.getById(2).getMovieSet().size());
    }
}