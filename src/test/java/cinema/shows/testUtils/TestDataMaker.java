package cinema.shows.testUtils;

import cinema.shows.entities.Category;
import cinema.shows.entities.Movie;
import cinema.shows.entities.Theater;
import cinema.shows.repos.CategoryRepo;
import cinema.shows.repos.MovieRepo;
import cinema.shows.repos.TheaterRepo;

public class TestDataMaker {
    public static int createCategory(CategoryRepo categoryRepo){
        categoryRepo.deleteAll();
        return categoryRepo.save(new Category(1,"drama")).getId();
    }

    public static int createMovie(MovieRepo movieRepo, int categoryId){
        movieRepo.deleteAll();
        return movieRepo.save(new Movie("Godfather", 9, (short) 16, "A classic for any time...",categoryId, "https://images.seoghoer.dk/s3fs-public/media/article/the-godfather.png","https://www.youtube.com/watch?v=sY1S34973zA")).getId();
    }

    public static int createTheater(TheaterRepo theaterRepo){
        theaterRepo.deleteAll();
        return theaterRepo.save(new Theater(1, "Norrebro", "Lygten 16", "Copenhagen", 2400)).getId();
    }
}
