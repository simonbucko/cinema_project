package cinema.shows.services;

import cinema.shows.dtos.MovieDTO;

public interface MovieServices {
    MovieDTO addMovie(MovieDTO movieDTO);
    MovieDTO getMovie(int id);
    MovieDTO updateMovie(MovieDTO movieDTO);
    void removeMovie(int movieId);
}
