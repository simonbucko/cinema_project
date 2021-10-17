package cinema.shows.services;

import cinema.shows.dtos.InputMoviePlayingDTO;
import cinema.shows.dtos.MovieDTOFull;
import cinema.shows.dtos.MoviePlayingDTOFull;
import cinema.shows.dtos.MoviePlayingDTOMin;
import cinema.shows.entities.MoviePlaying;
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

    private List<MoviePlayingDTOFull> getMoviesPlayingDTOs(List<MoviePlaying> moviesPlaying) {
        List<MoviePlayingDTOFull> moviePlayingDTOFulls = new ArrayList<>();
        for (MoviePlaying m: moviesPlaying) {
            MoviePlayingDTOFull moviePlayingDTOFull = new MoviePlayingDTOFull();
            MovieDTOFull movieDTOFull = new MovieDTOFull(m.getMovie());
            moviePlayingDTOFull.setMovieDTOFull(movieDTOFull);
            moviePlayingDTOFull.setDateStarts(m.getDateStarts());
            moviePlayingDTOFull.setDateEnds(m.getDateEnds());
            moviePlayingDTOFull.setTheater(m.getTheater().getName());
            moviePlayingDTOFulls.add(moviePlayingDTOFull);
        }
        return moviePlayingDTOFulls;
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingForDate(Date date) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(date, date);
        return getMoviesPlayingDTOs(moviesPlaying);
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        List<MoviePlaying> moviesPlaying =
                moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,dateEnds);
        return getMoviesPlayingDTOs(moviesPlaying);
    }

    @Override
    public MoviePlayingDTOMin addMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        return null;
    }

    @Override
    public MoviePlayingDTOMin updateMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        return null;
    }

    @Override
    public void removeMoviePlayingInTheater(Integer movieId, Integer theaterId) {

    }

    @Override
    public MoviePlayingDTOFull getMoviePlayingInTheater(Integer movieId, Integer theaterId) {
        return null;
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingInTheater(Integer theaterId) {
        return null;
    }
}
