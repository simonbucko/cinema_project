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
//    @Sql("/createMovie.sql")
//    @Sql("/createActor.sql")
    public void testBidirectionalRel() {
        //check the sql scripts worked
        actorRepo.save(new Actor(1,"Al","Pacino"));
        assertEquals(1, actorRepo.count());
        movieRepo.save(new Movie(1,"Godfather",10, (short) 16,"a classic...",1));
        assertEquals(1, movieRepo.count());
        //getting one actor from the db
        Actor actorOne = actorRepo.getById(1);
        //creating new actor
        Actor actorTwo = new Actor("Robert","De Niro");
        //actor yet not saved
        assertEquals(1, actorRepo.count());
        //getting the movie from the db
        Movie movieOne = movieRepo.getById(1);
        //set the movie's actor list
//        movieOne.addActor(actorTwo);
        List<Actor> actors = new ArrayList<>(Arrays.asList(actorTwo));
        movieOne.setActorSet(new HashSet(actors));
        //check there are no actors for that movie yet since we didn't save the movie yet
        assertEquals(0, movieRepo.getById(1).getActorSet().size());
        //save the movie
        movieRepo.save(movieOne);
        //AND Actor present in movies list BECAUSE OF THE BIDIRECTIONAL WAY OF SAVING provided by HIBERNATE
        assertEquals(1, movieRepo.getById(1).getActorSet().size());
//        System.out.println(movieOne.getActorSet());
        //AND Movie present in actors list
        assertEquals(2, actorRepo.count());

        assertEquals(1,actorRepo.getById(2).getMovieSet().size());

        Movie movieSaved = movieRepo.getById(1);
//        movieSaved.addActor(actorOne);
//        Movie movieRetrieved = movieRepo.save(movieSaved);
//        assertEquals(2, movieRetrieved.getActorSet().size());
        actorOne.getMovieSet().add(movieSaved);

        assertEquals(1, actorRepo.getById(1).getMovieSet().size());


//        assertEquals(1, actorRepo.getById(1).getMovieSet().size());
//        System.out.println(actorOne.getMovieSet());
        //so we will have to save the actor first in order to be added
//        Actor actorSaved = actorRepo.save(actorTwo);
        //COUNT
//        assertEquals(2, actorRepo.count());
        //lets save the movie again and QUERY the list of actors of the movie
//        Movie movieSaved = movieRepo.getById(1);
//        List<Actor> actorList = new ArrayList<>(Arrays.asList(actorTwo));
//        Set<Actor> actorSet = new HashSet(actorList);
//        System.out.println(movieOne.getActorSet());
//        movieSaved.getActorSet().add(actorSaved);
////        movieToSave.addActor(actorSaved);
//        movieSaved = movieRepo.save(movieSaved);
//        System.out.println(movieSaved.getActorSet());
//        assertEquals(2, movieSaved.getActorSet().size());
//        // Querying the actors side we should get a list of the movies he's playing in
//        assertEquals(1, actorRepo.getById(2).getMovieSet().size());
    }
}