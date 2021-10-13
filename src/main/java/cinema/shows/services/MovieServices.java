package cinema.shows.services;

import cinema.shows.dtos.MovieDTO;

public interface MovieServices {
    MovieDTO updateMovie(MovieDTO movieDTO);
    void removeMovie(int movieId);
    MovieDTO addMovie(MovieDTO movieDTO);
}
