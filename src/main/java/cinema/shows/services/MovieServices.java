package cinema.shows.services;

import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTOFull;

public interface MovieServices {
    MovieDTOFull addMovie(InputMovieDTO inputMovieDTO);
    MovieDTOFull getMovie(int id);
    MovieDTOFull updateMovie(MovieDTOFull movieDTOFull, Boolean replace);
    void removeMovie(int movieId);
}
