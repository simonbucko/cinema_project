package cinema.shows.rest;

import cinema.shows.dtos.MovieDTO;
import org.springframework.http.ResponseEntity;

public interface MovieRESTAPI {
    ResponseEntity<MovieDTO> updateMovie(MovieDTO movieDTO);
    ResponseEntity<MovieDTO> addMovie(MovieDTO movieDTO);
    void removeMovie(int id);
}
