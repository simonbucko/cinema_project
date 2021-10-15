package cinema.shows.services;

import cinema.shows.dtos.EditMovieDTO;
import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;

public interface MovieServices {
    MovieDTO addMovie(InputMovieDTO inputMovieDTO);
    MovieDTO getMovie(int id);
    MovieDTO updateMovie(EditMovieDTO editMovieDTO);
    void removeMovie(int movieId);
}
