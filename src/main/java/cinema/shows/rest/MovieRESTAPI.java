package cinema.shows.rest;

import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTOFull;
import org.springframework.http.ResponseEntity;

public interface MovieRESTAPI {
    ResponseEntity<MovieDTOFull> addMovie(InputMovieDTO inputMovieDTO);
    ResponseEntity<MovieDTOFull> getMovie(int id);
    ResponseEntity<MovieDTOFull> updateMovie(MovieDTOFull movieDTOFull, Boolean replace);
    void removeMovie(int id);
}
