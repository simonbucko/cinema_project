package cinema.shows.rest;

import cinema.shows.dtos.EditMovieDTO;
import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;
import cinema.shows.services.MovieServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieRESTAPIImp implements MovieRESTAPI {
    private MovieServices movieServices;

    public MovieRESTAPIImp(MovieServices movieServices) {
        this.movieServices = movieServices;
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody InputMovieDTO movieDTO) {
        MovieDTO movie = movieServices.addMovie(movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable int id) {
        MovieDTO movie = movieServices.getMovie(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody EditMovieDTO movieDTO) {
        MovieDTO movie = movieServices.updateMovie(movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void removeMovie(@PathVariable int id) {
        movieServices.removeMovie(id);
    }
}
