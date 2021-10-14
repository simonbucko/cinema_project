package cinema.shows.services;

import cinema.shows.dtos.MovieDTO;
import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.entities.MoviePlaying;
import cinema.shows.entities.MoviePlayingPK;
import cinema.shows.repos.MoviePlayingRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviePlayingServicesImo implements MoviePlayingServices {
    private MoviePlayingRepo moviePlayingRepo;

    public MoviePlayingServicesImo(MoviePlayingRepo moviePlayingRepo) {
        this.moviePlayingRepo = moviePlayingRepo;
    }

    private List<MoviePlayingDTO> getMoviesPlayingDTOs(List<MoviePlaying> moviesPlaying) {
        List<MoviePlayingDTO> moviePlayingDTOS = new ArrayList<>();
        for (MoviePlaying m: moviesPlaying) {
            MoviePlayingDTO moviePlayingDTO = new MoviePlayingDTO();
            MovieDTO movieDTO = new MovieDTO(m.getMovie());
            int theaterId = m.getTheater().getId();
            int movieId = m.getMovie().getId();
            MoviePlayingPK moviePlayingPK = new MoviePlayingPK(movieId, theaterId);
            moviePlayingDTO.setMovieDTO(movieDTO);
            moviePlayingDTO.setMoviePlayingPK(moviePlayingPK);
            moviePlayingDTO.setDateStarts(m.getDateStarts());
            moviePlayingDTO.setDateEnds(m.getDateEnds());
            moviePlayingDTOS.add(moviePlayingDTO);
        }
        return moviePlayingDTOS;
    }

    @Override
    public List<MoviePlayingDTO> getAllMoviesPlayingForDate(Date date) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByDateStarts(date);
        return getMoviesPlayingDTOs(moviesPlaying);
    }

    @Override
    public List<MoviePlayingDTO> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByDateEndsIsBetween(dateStarts, dateEnds);
        return getMoviesPlayingDTOs(moviesPlaying);
    }
}
