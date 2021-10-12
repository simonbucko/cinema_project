package cinema.shows.repos;

import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class MovieRepoTest {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    ActorRepo actorRepo;

    @Test
    @Sql("/createMovie.sql")
    @Sql("/createActor.sql")
    public void testBidirectionalRel() {
        Movie m1 = movieRepo.getById(1);
        Actor a1 = actorRepo.getById(1);
//        Actor a1 = new Actor("Al","Pacino");
//        Actor a2 = new Actor("Robert","De Niro");
//        m1.setActorList(Arrays.asList(a1,a2));
        m1.getActorList().add(a1);
        Movie movieSaved = movieRepo.save(m1);
        assertTrue(movieSaved.getActorList().contains(a1));
//        assertEquals(2,actorRepo.count());
//        Actor actorRetrieved = actorRepo.getById(1);
//        assertTrue(actorRetrieved.getMovieList().contains(m1));
    }


}