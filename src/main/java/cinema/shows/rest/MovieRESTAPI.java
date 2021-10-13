package cinema.shows.rest;

import cinema.shows.dtos.MovieDTO;

public interface MovieRESTAPI {
    MovieDTO updateMovie(MovieDTO movieDTO);
    MovieDTO addMovie(MovieDTO movieDTO);
    void removeMovie(MovieDTO movieDTO);
}
