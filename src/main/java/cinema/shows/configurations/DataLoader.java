package cinema.shows.configurations;

import cinema.shows.entities.*;
import cinema.shows.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class DataLoader {
    private CategoryRepo categoryRepo;
    private MovieRepo movieRepo;
    private ActorRepo actorRepo;
    private TheaterRepo theaterRepo;
    private MoviePlayingRepo moviePlayingRepo;

    @Autowired
    public DataLoader(CategoryRepo categoryRepo, MovieRepo movieRepo,
                      ActorRepo actorRepo, MoviePlayingRepo moviePlayingRepo, TheaterRepo theaterRepo) {
        this.categoryRepo = categoryRepo;
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        this.theaterRepo = theaterRepo;
        this.moviePlayingRepo = moviePlayingRepo;
        if (categoryRepo.count() == 0) {
            loadCategories();
            loadMoviesAndActors();
            loadTheater();
            loadMoviesPlaying();
        }
    }

    private void loadCategories() {
        categoryRepo.save(new Category(1,"drama"));
        categoryRepo.save(new Category(2, "comedy"));
        categoryRepo.save(new Category(3, "sci-fy"));
    }

    private void loadMoviesAndActors() {
        Actor one = new Actor(1, "Al", "Pacino");
        Actor two = new Actor(2, "Robert", "DeNiro");
        Actor three = new Actor(3, "Jim", "Carrey");
        Actor four = new Actor(4, "Keanu", "Reeves");
        actorRepo.save(one);
        actorRepo.save(two);
        actorRepo.save(three);
        actorRepo.save(four);
        Movie godfather = new Movie(1,"The Godfather", 9, (short) 16, "A classic for any time...",1);
        List<Actor> actorListGodfather = new ArrayList(Arrays.asList(one,two));
        Set<Actor> actorSetGodfather = new HashSet(actorListGodfather);
        godfather.setActorSet(actorSetGodfather);
        movieRepo.save(godfather);
        Movie truman = new Movie(2, "The Truman Show", 8, (short) 12, "Something different...",2);
        List<Actor> actorListTruman = new ArrayList(Arrays.asList(three));
        Set<Actor> actorSetTruman = new HashSet(actorListTruman);
        truman.setActorSet(actorSetTruman);
        movieRepo.save(truman);
        Movie matrix = new Movie(3, "The Matrix", 10, (short) 14, "Will blow your mind...",3);
        List<Actor> actorListMatrix = new ArrayList(Arrays.asList(four));
        Set<Actor> actorSetMatrix = new HashSet(actorListMatrix);
        matrix.setActorSet(actorSetMatrix);
        movieRepo.save(matrix);
    }

    private void loadTheater() {
        theaterRepo.save(new Theater(1, "Norrebro", "Lygten 16", "Copenhagen", (short) 2400));
    }

    private void loadMoviesPlaying() {
        MoviePlayingPK moviePlayingPKOne = new MoviePlayingPK(1, 1);
        Date dateStartsGodfather = Date.valueOf("2021-10-15");
        Date dateEndsGodfather = Date.valueOf("2021-10-21");
        MoviePlaying moviePlayingGodfather = new MoviePlaying(moviePlayingPKOne, dateStartsGodfather, dateEndsGodfather);
        moviePlayingRepo.save(moviePlayingGodfather);
        MoviePlayingPK moviePlayingPKTwo= new MoviePlayingPK(2, 1);
        Date dateStartsTrumanShow = Date.valueOf("2021-10-17");
        Date dateEndsTrumanShow = Date.valueOf("2021-10-23");
        MoviePlaying moviePlayingTrumanShow = new MoviePlaying(moviePlayingPKTwo, dateStartsTrumanShow, dateEndsTrumanShow);
        moviePlayingRepo.save(moviePlayingTrumanShow);
        MoviePlayingPK moviePlayingPKThree= new MoviePlayingPK(3, 1);
        Date dateStartsMatrix = Date.valueOf("2021-10-19");
        Date dateEndsMatrix = Date.valueOf("2021-10-25");
        MoviePlaying moviePlayingMatrix= new MoviePlaying(moviePlayingPKThree, dateStartsMatrix, dateEndsMatrix);
        moviePlayingRepo.save(moviePlayingMatrix);
    }
}
