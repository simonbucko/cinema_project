package cinema.shows.rest;

import cinema.shows.dtos.MovieDTO;
import org.springframework.http.ResponseEntity;

public interface MovieRESTAPI {
    ResponseEntity<MovieDTO> addMovie(MovieDTO movieDTO);
    ResponseEntity<MovieDTO> getMovie(int id);
    ResponseEntity<MovieDTO> updateMovie(MovieDTO movieDTO);
    void removeMovie(int id);
}
