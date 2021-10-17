package cinema.shows.services;

import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTOFull;
import cinema.shows.dtos.MovieDTOMin;
import cinema.shows.entities.Movie;

import java.util.List;

public interface MovieServices {
    MovieDTOFull addMovie(InputMovieDTO inputMovieDTO);
    MovieDTOFull getMovie(Integer movieId);
    MovieDTOFull updateMovie(MovieDTOFull movieDTOFull, Boolean replace);
    void removeMovie(Integer movieId);

    List<MovieDTOFull> getAllMovies();
    List<MovieDTOMin> getAllMinMovies();

    MovieDTOMin getMovieDTOMinFromMovie(Movie movie);
    MovieDTOFull getMovieDTOFullFromMovie(Movie movie);
}
