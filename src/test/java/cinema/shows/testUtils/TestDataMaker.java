package cinema.shows.testUtils;

import cinema.shows.entities.Category;
import cinema.shows.entities.Movie;
import cinema.shows.repos.CategoryRepo;
import cinema.shows.repos.MovieRepo;

public class TestDataMaker {

    public static Category createCategory(CategoryRepo categoryRepo){
        categoryRepo.deleteAll();
        return categoryRepo.save(new Category(1,"drama"));
    }

    public static Movie createMovie(MovieRepo movieRepo){
        movieRepo.deleteAll();
        return movieRepo.save(new Movie(1,"Godfather",10,(short)2,"a classic...",1));
    }
}
