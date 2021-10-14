package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTO;
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
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDate(
            @RequestParam("date") String date) {
        Date dateLooked = Date.valueOf(date);
        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDate(dateLooked);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(
            @RequestParam("dateStarts") String dateStarts,
            @RequestParam("dateEnds") String dateEnds) {
        Date dateStarting = Date.valueOf(dateStarts);
        Date dateEnding = Date.valueOf(dateEnds);
        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDates(dateStarting,dateEnding);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }
}
