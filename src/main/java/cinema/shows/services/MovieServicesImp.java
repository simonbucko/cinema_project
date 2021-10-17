package cinema.shows.services;

import cinema.shows.dtos.*;
import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import cinema.shows.exceptions.ResourceNotFoundException;
import cinema.shows.repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServicesImp implements MovieServices {
    private MovieRepo movieRepo;
    @Autowired
    ActorServices actorServices;

    public MovieServicesImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    private String errorMessage(Integer id){
        return "Resource Not found with id = " + id;
    }

    @Override
    public MovieDTOFull addMovie(InputMovieDTO inputMovieDTO) {
        Movie newMovie = new Movie(inputMovieDTO);
        Movie movieSaved = movieRepo.save(newMovie);
        return new MovieDTOFull(movieSaved);
    }

    @Override
    public MovieDTOFull getMovie(Integer movieId) {
        Movie movie = movieRepo.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(movieId)));
        return new MovieDTOFull(movie);
    }

    @Override
    public MovieDTOFull updateMovie(MovieDTOFull movieDTO, Boolean replace) {
        Movie movieInDB = movieRepo.findById(movieDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(movieDTO.getId())));
        String title = movieDTO.getTitle();
        Double rating = movieDTO.getRating();
        Short minAge = movieDTO.getMinAge();
        String description = movieDTO.getDescription();
        Integer categoryId = movieDTO.getCategoryId();
        List<ActorDTO> actors = movieDTO.getActorList();
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
        if (actors != null) {
            List<Actor> actorList = actorServices.saveAll(actors);
            Set<Actor> actorSet = new HashSet(actorList);
            if (replace) {
                movieInDB.setActorSet(actorSet);
            } else {
                movieInDB.getActorSet().addAll(actorSet);
            }
        }
        Movie movieSaved = movieRepo.save(movieInDB);
        return new MovieDTOFull(movieSaved);
    }

    @Override
    public void removeMovie(Integer movieId) {
        movieRepo.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(movieId)));
        movieRepo.deleteById(movieId);
    }

    @Override
    public List<MovieDTOFull> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();
        List<MovieDTOFull> movieDTOsFull = new ArrayList<>();
        for (Movie movie: movies) {
            movieDTOsFull.add(new MovieDTOFull(movie));
        }
        return movieDTOsFull;
    }

    @Override
    public List<MovieDTOMin> getAllMinMovies() {
        List<Movie> movies = movieRepo.findAll();
        List<MovieDTOMin> movieDTOsMin = new ArrayList<>();
        for (Movie movie: movies) {
            movieDTOsMin.add(new MovieDTOMin(movie));
        }
        return movieDTOsMin;
    }
}
