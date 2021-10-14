package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTO;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingRESTAPI {
    ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDate(String date);
    ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(String dateStarts, String dateEnds);
}
