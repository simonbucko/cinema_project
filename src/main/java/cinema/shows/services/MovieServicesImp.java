package cinema.shows.services;

import cinema.shows.dtos.EditMovieDTO;
import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;
import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import cinema.shows.repos.ActorRepo;
import cinema.shows.repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServicesImp implements MovieServices {
    private MovieRepo movieRepo;
    @Autowired
    ActorRepo actorRepo;


    public MovieServicesImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public MovieDTO addMovie(InputMovieDTO inputMovieDTO) {
        Movie newMovie = new Movie(inputMovieDTO);
        Movie movieSaved = movieRepo.save(newMovie);
        return new MovieDTO(movieSaved);
    }

    @Override
    public MovieDTO getMovie(int id) {
        return new MovieDTO(movieRepo.getById(id));
    }

    @Override
    public MovieDTO updateMovie(EditMovieDTO movieDTO) {
        Movie movieInDB = movieRepo.getById(movieDTO.getId());
        String title = movieDTO.getTitle();
        Double rating = movieDTO.getRating();
        Short minAge = movieDTO.getMinAge();
        String description = movieDTO.getDescription();
        Integer categoryId = movieDTO.getCategoryId();
        List<Actor> actorDTOList = movieDTO.getActorList();
        if (title != null) {
            movieInDB.setTitle(title);
        }
        if (rating != null) {
            movieInDB.setRating(rating);
        }
        if (minAge != null) {
            movieInDB.setMinAge(minAge);
        }
        if (description != null) {
            movieInDB.setDescription(description);
        }
        if (categoryId != null) {
            movieInDB.setCategoryId(categoryId);
        }
        if (actorDTOList != null) {
            Set<Actor> actorSet = new HashSet(actorDTOList);
            actorRepo.saveAll(actorDTOList);
            movieInDB.getActorSet().addAll(actorSet);
        }
        Movie movieSaved = movieRepo.save(movieInDB);
        return new MovieDTO(movieSaved);
    }

    @Override
    public void removeMovie(int movieId) {
        movieRepo.deleteById(movieId);
    }

}
