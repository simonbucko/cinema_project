package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTO;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingRESTAPI {
    ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDate(Date date);
    ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds);
}
