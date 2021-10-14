package cinema.shows.repos;

import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

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
    @Sql("/createActor.sql")
    public void testBidirectionalRel() {
        //check the sql scripts worked
        System.out.println(actorRepo.getById(1));
        assertEquals(1, actorRepo.count());
        assertEquals(1, movieRepo.count());
        //getting one actor from the db
        Actor a1 = actorRepo.getById(1);
        //creating new actor
        Actor a2 = new Actor(2,"Robert","De Niro");
        actorRepo.save(a2);
        //actor yet not saved
        assertEquals(1, actorRepo.count());
        //getting the movie from the db
        Movie m1 = movieRepo.getById(1);
        //set the movie's actor list
        m1.setActorList(Arrays.asList(a1,a2));
        //check there are no actors for that movie yet
        assertEquals(0, movieRepo.getById(1).getActorList().size());
        //check there is one saved actor just
        assertEquals(2, actorRepo.count());
        //save the movie
        movieRepo.save(m1);
        //now we have two movies
        assertEquals(2, movieRepo.getById(1).getActorList().size());
        // AND TWO Actors
        assertEquals(2, actorRepo.count());
        // Querying the actors side we should get a list of the movies he's playing in
        assertEquals(1, actorRepo.getById(1).getMovieList().size());
    }
}