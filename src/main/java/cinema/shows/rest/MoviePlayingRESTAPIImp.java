package cinema.shows.rest;

import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.services.MoviePlayingServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/moviesplaying")
public class MoviePlayingRESTAPIImp implements MoviePlayingRESTAPI {
    private MoviePlayingServices moviePlayingServices;

    public MoviePlayingRESTAPIImp(MoviePlayingServices moviePlayingServices) {
        this.moviePlayingServices = moviePlayingServices;
    }

    @Override
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDate(Date date) {
        return null;
    }

    @Override
    public ResponseEntity<List<MoviePlayingDTO>> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        return null;
    }
}
