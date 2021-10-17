package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTOFull;
import cinema.shows.services.MoviePlayingServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/playing")
public class MoviePlayingRESTAPIImp implements MoviePlayingRESTAPI {
    private MoviePlayingServices moviePlayingServices;

    public MoviePlayingRESTAPIImp(MoviePlayingServices moviePlayingServices) {
        this.moviePlayingServices = moviePlayingServices;
    }

    @GetMapping("/date")
    public ResponseEntity<List<MoviePlayingDTOFull>> getAllMoviesPlayingForDate(
            @RequestParam("date") String date) {
        Date dateLooked = Date.valueOf(date);
        List<MoviePlayingDTOFull> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDate(dateLooked);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<MoviePlayingDTOFull>> getAllMoviesPlayingForDates(
            @RequestParam("dateStarts") String dateStarts,
            @RequestParam("dateEnds") String dateEnds) {
        Date dateStarting = Date.valueOf(dateStarts);
        Date dateEnding = Date.valueOf(dateEnds);
        List<MoviePlayingDTOFull> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDates(dateStarting,dateEnding);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }
}
