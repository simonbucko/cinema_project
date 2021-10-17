package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTOFull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MoviePlayingRESTAPI {
    ResponseEntity<List<MoviePlayingDTOFull>> getAllMoviesPlayingForDate(String date);
    ResponseEntity<List<MoviePlayingDTOFull>> getAllMoviesPlayingForDates(String dateStarts, String dateEnds);
}
