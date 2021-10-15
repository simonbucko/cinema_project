package cinema.shows.configurations;

import cinema.shows.entities.*;
import cinema.shows.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

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
            loadMovies();
            loadActors();
            loadTheater();
            loadMoviesPlaying();
        }
    }

    private void loadCategories() {
        categoryRepo.save(new Category(1,"drama"));
        categoryRepo.save(new Category(2, "comedy"));
        categoryRepo.save(new Category(3, "sci-fy"));
    }

    private void loadMovies() {
        movieRepo.save(new Movie(1,"The Godfather", 9, (short) 16, "A classic for any time...",1));
        movieRepo.save(new Movie(2,"The Truman Show", 8, (short) 12, "Something different...",2));
        movieRepo.save(new Movie(3,"The Matrix", 10, (short) 14, "Will twist your mind...",3));
    }

    private void loadActors() {
        actorRepo.save(new Actor(1, "Al", "Pacino"));
        actorRepo.save(new Actor(2, "Robert", "DeNiro"));
        actorRepo.save(new Actor(3, "Jim", "Carrey"));
        actorRepo.save(new Actor(4, "Keanu", "Reeves"));
    }

    private void loadTheater() {
        theaterRepo.save(new Theater(1,"Lygten 16", "Copenhagen", (short) 2400));
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
