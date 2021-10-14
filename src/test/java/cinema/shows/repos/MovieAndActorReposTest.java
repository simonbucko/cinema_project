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
class MovieAndActorReposTest {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    ActorRepo actorRepo;

    @Test
    @Sql("/createCategory.sql")
    @Sql("/createMovie.sql")
    @Sql("/createActor.sql")
    public void testBidirectionalRel() {
        assertEquals(1, actorRepo.count());
        assertEquals(1, movieRepo.count());

        Actor a1 = actorRepo.getById(1);
        Actor a2 = new Actor(2,"Robert","De Niro");
        assertEquals(1, actorRepo.count());

        Movie m1 = movieRepo.getById(1);
        m1.setActorList(Arrays.asList(a1,a2));
        assertEquals(0, movieRepo.getById(1).getActorList().size());
        assertEquals(1, actorRepo.count());

        movieRepo.save(m1);
        assertEquals(2, movieRepo.getById(1).getActorList().size());
        assertEquals(2, actorRepo.count());
        assertEquals(1, actorRepo.getById(1).getMovieList().size());

    }


}