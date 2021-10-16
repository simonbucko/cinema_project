package cinema.shows.services;

import cinema.shows.dtos.InputMoviePlayingDTO;
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
public class MoviePlayingServicesImp implements MoviePlayingServices {
    private MoviePlayingRepo moviePlayingRepo;

    public MoviePlayingServicesImp(MoviePlayingRepo moviePlayingRepo) {
        this.moviePlayingRepo = moviePlayingRepo;
    }

    private List<MoviePlayingDTO> getMoviesPlayingDTOs(List<MoviePlaying> moviesPlaying) {
        List<MoviePlayingDTO> moviePlayingDTOS = new ArrayList<>();
        for (MoviePlaying m: moviesPlaying) {
            MoviePlayingDTO moviePlayingDTO = new MoviePlayingDTO();
            MovieDTO movieDTO = new MovieDTO(m.getMovie());
            moviePlayingDTO.setMovieDTO(movieDTO);
            moviePlayingDTO.setDateStarts(m.getDateStarts());
            moviePlayingDTO.setDateEnds(m.getDateEnds());
            moviePlayingDTO.setTheater(m.getTheater().getName());
            moviePlayingDTOS.add(moviePlayingDTO);
        }
        return moviePlayingDTOS;
    }

    @Override
    public List<MoviePlayingDTO> getAllMoviesPlayingForDate(Date date) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(date, date);
        return getMoviesPlayingDTOs(moviesPlaying);
    }

    @Override
    public List<MoviePlayingDTO> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        List<MoviePlaying> moviesPlaying =
                moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,dateEnds);
        return getMoviesPlayingDTOs(moviesPlaying);
    }

    @Override
    public MoviePlayingDTO addMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        return null;
    }

    @Override
    public MoviePlayingDTO updateMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        return null;
    }

    @Override
    public void removeMoviePlayingInTheater(MoviePlayingPK moviePlayingPK) {

    }

    @Override
    public MoviePlayingDTO getMoviePlayingInTheater(MoviePlayingPK moviePlayingPK) {
        return null;
    }

    @Override
    public List<MoviePlayingDTO> getAllMoviesPlayingInTheater(int theaterId) {
        return null;
    }
}
