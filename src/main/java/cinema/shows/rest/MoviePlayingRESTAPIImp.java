package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.services.MoviePlayingServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/moviesplaying")
public class MoviePlayingRESTAPIImp implements MoviePlayingRESTAPI {
    private MoviePlayingServices moviePlayingServices;

    public MoviePlayingRESTAPIImp(MoviePlayingServices moviePlayingServices) {
        this.moviePlayingServices = moviePlayingServices;
    }

    @GetMapping("/{date)")
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDate(
            @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDate(date);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }

    @GetMapping("/{dateStarts}/{dateEnds}")
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(
            @RequestParam("dateStarts") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateStarts,
            @RequestParam("dateEnds") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateEnds) {
        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDates(dateStarts,dateEnds);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }
}
