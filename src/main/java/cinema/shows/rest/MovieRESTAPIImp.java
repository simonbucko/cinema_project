package cinema.shows.rest;

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

    @PutMapping("/editMovie")
    public ResponseEntity<MovieDTO> updateMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO movie = movieServices.updateMovie(movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO movie = movieServices.addMovie(movieDTO);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/removeMovie/{id}")
    public void removeMovie(@PathVariable int id) {
        movieServices.removeMovie(id);
    }
}
