package cinema.shows.services;

import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;

public interface MovieServices {
    MovieDTO addMovie(InputMovieDTO inputMovieDTO);
    MovieDTO getMovie(int id);
    MovieDTO updateMovie(MovieDTO movieDTO);
    void removeMovie(int movieId);
}
