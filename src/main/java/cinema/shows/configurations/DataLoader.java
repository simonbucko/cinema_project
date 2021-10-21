package cinema.shows.configurations;

import cinema.shows.entities.*;
import cinema.shows.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Component
public class DataLoader {
    private CategoryRepo categoryRepo;
    private MovieRepo movieRepo;
    private ActorRepo actorRepo;
    private TheaterRepo theaterRepo;
    private MoviePlayingRepo moviePlayingRepo;
    private HallRepo hallRepo;
    private ShowRepo showRepo;
    private SeatRepo seatRepo;

    @Autowired
    public DataLoader(CategoryRepo categoryRepo, MovieRepo movieRepo,
                      ActorRepo actorRepo, MoviePlayingRepo moviePlayingRepo,
                      TheaterRepo theaterRepo, HallRepo hallRepo, ShowRepo showRepo, SeatRepo seatRepo) {
        this.categoryRepo = categoryRepo;
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
        this.theaterRepo = theaterRepo;
        this.moviePlayingRepo = moviePlayingRepo;
        this.hallRepo = hallRepo;
        this.showRepo = showRepo;
        this.seatRepo = seatRepo;
        if (categoryRepo.count() == 0) {
            loadCategories();
            loadMoviesAndActors();
            loadTheater();
            loadMoviesPlaying();
            loadHall();
            loadShows();
            loadSeats();
        }
    }

    private void loadCategories() {
        categoryRepo.save(new Category(1,"drama"));
        categoryRepo.save(new Category(2, "comedy"));
        categoryRepo.save(new Category(3, "sci-fy"));
    }

    Movie movieOne;
    Movie movieTwo;
    Movie movieThree;
    Theater theater;
    Hall hall;

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
        movieOne = movieRepo.save(godfather);
        Movie truman = new Movie(2, "The Truman Show", 8, (short) 12, "Something different...",2);
        List<Actor> actorListTruman = new ArrayList(Arrays.asList(three));
        Set<Actor> actorSetTruman = new HashSet(actorListTruman);
        truman.setActorSet(actorSetTruman);
        movieTwo = movieRepo.save(truman);
        Movie matrix = new Movie(3, "The Matrix", 10, (short) 14, "Will blow your mind...",3);
        List<Actor> actorListMatrix = new ArrayList(Arrays.asList(four));
        Set<Actor> actorSetMatrix = new HashSet(actorListMatrix);
        matrix.setActorSet(actorSetMatrix);
        movieThree = movieRepo.save(matrix);
    }

    private void loadTheater() {
        theater = theaterRepo.save(new Theater(1, "Norrebro", "Lygten 16", "Copenhagen", 2400));}

    MoviePlaying moviePlayingOne;
    MoviePlaying moviePlayingTwo;
    MoviePlaying moviePlayingThree;

    private void loadMoviesPlaying() {
        Date dateStartsGodfather = Date.valueOf("2021-10-15");
        Date dateEndsGodfather = Date.valueOf("2021-10-21");
        MoviePlaying moviePlayingGodfather = new MoviePlaying(dateStartsGodfather, dateEndsGodfather, movieOne.getId(), theater);
        moviePlayingOne = moviePlayingRepo.save(moviePlayingGodfather);
        Date dateStartsTrumanShow = Date.valueOf("2021-10-17");
        Date dateEndsTrumanShow = Date.valueOf("2021-10-23");
        MoviePlaying moviePlayingTrumanShow = new MoviePlaying(dateStartsTrumanShow, dateEndsTrumanShow, movieTwo.getId(), theater);
        moviePlayingTwo = moviePlayingRepo.save(moviePlayingTrumanShow);
        Date dateStartsMatrix = Date.valueOf("2021-10-19");
        Date dateEndsMatrix = Date.valueOf("2021-10-25");
        MoviePlaying moviePlayingMatrix= new MoviePlaying(dateStartsMatrix, dateEndsMatrix, movieThree.getId(), theater);
        moviePlayingThree = moviePlayingRepo.save(moviePlayingMatrix);
    }

    private void loadHall() {
        hall = hallRepo.save(new Hall(1, 5, 5, "Room One", 1));
    }

    private void loadShows() {
        Show showOneGodfather = new Show(Date.valueOf("2021-10-16"),Time.valueOf("15:00:00"),moviePlayingOne,hall);
        showRepo.save(showOneGodfather);
    }

    private void loadSeats(){
        Seat seat1 = new Seat(1,(short)1,"A");
        Seat seat2 = new Seat(2,(short)1,"B");
        Seat seat3 = new Seat(3,(short)1,"C");
        Seat seat4 = new Seat(4,(short)1,"D");
        Seat seat = seatRepo.save(seat1);
        System.out.println(seat);
        seatRepo.save(seat2);
        seatRepo.save(seat3);
        seatRepo.save(seat4);
    }
}
