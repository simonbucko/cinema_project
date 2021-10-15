package cinema.shows.configurations;

import cinema.shows.entities.*;
import cinema.shows.repos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.*;

//@Configuration
public class DataBootstrap implements CommandLineRunner {
    CategoryRepo categoryRepo;
    MovieRepo movieRepo;
    ActorRepo actorRepo;
    MoviePlayingRepo moviePlayingRepo;
    TheaterRepo theaterRepo;

    public DataBootstrap(CategoryRepo categoryRepo, MovieRepo movieRepo,
                         ActorRepo actorRepo, MoviePlayingRepo moviePlayingRepo,
                         TheaterRepo theaterRepo) {
        this.categoryRepo = categoryRepo;
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        this.moviePlayingRepo = moviePlayingRepo;
        this.theaterRepo = theaterRepo;
    }

    @Override
    public void run(String... args) {
        Category category = new Category(1,"drama");
        categoryRepo.save(category);

        Actor actorOne = new Actor(1,"Al", "Pacino");
        actorRepo.save(actorOne);
        Actor actorTwo = new Actor(2, "Robert", "De Niro");
        actorRepo.save(actorTwo);
        Movie movieOne = new Movie(1,"The Godfather", 10, (short) 16, "A classic for any time...",1);
        List<Actor> actors = new ArrayList<>(Arrays.asList(actorOne, actorTwo));
        movieOne.setActorSet(new HashSet(actors));
        movieRepo.save(movieOne);

        Theater theater = new Theater(1,"Lygten 16", "Copenhagen", (short) 2400);
        theaterRepo.save(theater);

        MoviePlayingPK moviePlayingPK = new MoviePlayingPK(1, 1);
        Date dateStarts = Date.valueOf("2021-11-11");
        Date dateEnds = Date.valueOf("2021-11-22");
        MoviePlaying moviePlaying = new MoviePlaying(moviePlayingPK, dateStarts, dateEnds);
        moviePlayingRepo.save(moviePlaying);
    }
}
