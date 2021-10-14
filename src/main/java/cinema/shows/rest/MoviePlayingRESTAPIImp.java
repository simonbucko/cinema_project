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
@RequestMapping("/api/movies/now")
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
            @PathVariable("dateStarts") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateStarts,
            @PathVariable("dateEnds") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateEnds) {
        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDates(dateStarts,dateEnds);
        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
    }

//    @GetMapping("/{dateStarts}/{dateEnds}")
//    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(
//            @PathVariable("dateStarts") String dateStarts,
//            @PathVariable("dateEnds") String dateEnds) {
//        Date dateStarting = Date.valueOf(dateStarts);
//        Date dateEnding = Date.valueOf(dateEnds);
//        List<MoviePlayingDTO> moviePlaying = moviePlayingServices.getAllMoviesPlayingForDates(dateStarting,dateEnding);
//        return new ResponseEntity<>(moviePlaying, HttpStatus.OK);
//    }
}
