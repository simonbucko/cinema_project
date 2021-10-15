package cinema.shows.rest;

import cinema.shows.dtos.EditMovieDTO;
import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;
import org.springframework.http.ResponseEntity;

public interface MovieRESTAPI {
    ResponseEntity<MovieDTO> addMovie(InputMovieDTO inputMovieDTO);
    ResponseEntity<MovieDTO> getMovie(int id);
    ResponseEntity<MovieDTO> updateMovie(EditMovieDTO editMovieDTO);
    void removeMovie(int id);
}
