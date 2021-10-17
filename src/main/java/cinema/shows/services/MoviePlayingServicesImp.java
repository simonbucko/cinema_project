package cinema.shows.services;

import cinema.shows.dtos.*;
import cinema.shows.entities.MoviePlaying;
import cinema.shows.entities.MoviePlayingPK;
import cinema.shows.exceptions.ResourceNotFoundException;
import cinema.shows.repos.MoviePlayingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviePlayingServicesImp implements MoviePlayingServices {
    private MoviePlayingRepo moviePlayingRepo;
    @Autowired
    MovieServices movieServices;

    public MoviePlayingServicesImp(MoviePlayingRepo moviePlayingRepo) {
        this.moviePlayingRepo = moviePlayingRepo;
    }

    private String errorMessage(Integer movieId, Integer theaterId){
        return "Resource Not found with movieId = " + movieId + " and theaterId = " + theaterId;
    }

    @Override
    public MoviePlaying getMoviePlaying(Integer moviePlayingId, Integer theaterId) {
        return moviePlayingRepo.findById(new MoviePlayingPK(moviePlayingId,theaterId))
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(moviePlayingId, theaterId)));
    }

    private MoviePlayingDTOFull getMoviePlayingDTOFull(MoviePlaying moviePlaying) {
        MoviePlayingDTOFull moviePlayingDTOFull = new MoviePlayingDTOFull();
        MovieDTOFull movieDTOFull = movieServices.getMovieDTOFullFromMovie(moviePlaying.getMovie());
        moviePlayingDTOFull.setMovieDTOFull(movieDTOFull);
        moviePlayingDTOFull.setDateStarts(moviePlaying.getDateStarts());
        moviePlayingDTOFull.setDateEnds(moviePlaying.getDateEnds());
        moviePlayingDTOFull.setTheater(moviePlaying.getTheater().getName());
        return moviePlayingDTOFull;
    }
    private List<MoviePlayingDTOFull> getMoviesPlayingDTOsFull(List<MoviePlaying> moviesPlaying) {
        List<MoviePlayingDTOFull> moviePlayingDTOsFull = new ArrayList<>();
        for (MoviePlaying m: moviesPlaying) {
            moviePlayingDTOsFull.add(getMoviePlayingDTOFull(m));
        }
        return moviePlayingDTOsFull;
    }
    private MoviePlayingDTOMin getMoviePlayingDTOMin(MoviePlaying moviePlaying) {
        MoviePlayingDTOMin moviePlayingDTOMin = new MoviePlayingDTOMin();
        MovieDTOMin movieDTOMin = movieServices.getMovieDTOMinFromMovie(moviePlaying.getMovie());
        moviePlayingDTOMin.setMovieDTOMin(movieDTOMin);
        moviePlayingDTOMin.setDateStarts(moviePlaying.getDateStarts());
        moviePlayingDTOMin.setDateEnds(moviePlaying.getDateEnds());
        moviePlayingDTOMin.setTheater(moviePlaying.getTheater().getName());
        return moviePlayingDTOMin;
    }
    private List<MoviePlayingDTOMin> getMoviesPlayingDTOsMin(List<MoviePlaying> moviesPlaying) {
        List<MoviePlayingDTOMin> moviePlayingDTOsMin = new ArrayList<>();
        for (MoviePlaying m: moviesPlaying) {
            moviePlayingDTOsMin.add(getMoviePlayingDTOMin(m));
        }
        return moviePlayingDTOsMin;
    }

    @Override
    public MoviePlayingDTOMin addMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        MoviePlaying newMoviePlaying = new MoviePlaying(inputMoviePlayingDTO);
        MoviePlaying moviePlayingSaved = moviePlayingRepo.save(newMoviePlaying);
        return getMoviePlayingDTOMin(moviePlayingSaved);
    }

    @Override
    public MoviePlayingDTOMin updateMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO) {
        int movieId = inputMoviePlayingDTO.getMovieId();
        int theaterId = inputMoviePlayingDTO.getTheaterId();
        MoviePlaying moviePlayingInDB = getMoviePlaying(movieId,theaterId);
        Date dateStarts = inputMoviePlayingDTO.getDateStarts();
        Date dateEnds = inputMoviePlayingDTO.getDateEnds();
        if (dateStarts != null) {
            moviePlayingInDB.setDateStarts(dateStarts);
        }
        if (dateEnds != null) {
            moviePlayingInDB.setDateEnds(dateEnds);
        }
        MoviePlaying moviePlayingSaved = moviePlayingRepo.save(moviePlayingInDB);
        return getMoviePlayingDTOMin(moviePlayingSaved);
    }

    @Override
    public void removeMoviePlayingInTheater(Integer movieId, Integer theaterId) {
        getMoviePlaying(movieId,theaterId);
        moviePlayingRepo.deleteById(new MoviePlayingPK(movieId,theaterId));
    }

    @Override
    public MoviePlayingDTOFull getMoviePlayingInTheater(Integer movieId, Integer theaterId) {
        MoviePlaying moviePlaying = getMoviePlaying(movieId,theaterId);
        return getMoviePlayingDTOFull(moviePlaying);
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingInTheater(Integer theaterId) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByTheaterId(theaterId);
        List<MoviePlayingDTOFull> moviesPlayingDTOsFull = new ArrayList<>();
        if (!moviesPlaying.isEmpty()) {
            moviesPlayingDTOsFull = getMoviesPlayingDTOsFull(moviesPlaying);
        }
        return moviesPlayingDTOsFull;
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingForDate(Date date) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.
                getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(date, date);
        return getMoviesPlayingDTOsFull(moviesPlaying);
    }

    @Override
    public List<MoviePlayingDTOFull> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        List<MoviePlaying> moviesPlaying =
                moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,dateEnds);
        return getMoviesPlayingDTOsFull(moviesPlaying);
    }

    @Override
    public MoviePlayingDTOMin getMinMoviePlayingInTheater(Integer movieId, Integer theaterId) {
        MoviePlaying moviePlaying = getMoviePlaying(movieId,theaterId);
        return getMoviePlayingDTOMin(moviePlaying);
    }

    @Override
    public List<MoviePlayingDTOMin> getAllMinMoviesPlayingInTheater(Integer theaterId) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.getAllByTheaterId(theaterId);
        List<MoviePlayingDTOMin> moviesPlayingDTOsMin = new ArrayList<>();
        if (!moviesPlaying.isEmpty()) {
            moviesPlayingDTOsMin = getMoviesPlayingDTOsMin(moviesPlaying);
        }
        return moviesPlayingDTOsMin;
    }

    @Override
    public List<MoviePlayingDTOMin> getAllMinMoviesPlayingForDate(Date date) {
        List<MoviePlaying> moviesPlaying = moviePlayingRepo.
                getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(date, date);
        return getMoviesPlayingDTOsMin(moviesPlaying);
    }

    @Override
    public List<MoviePlayingDTOMin> getAllMinMoviesPlayingForDates(Date dateStarts, Date dateEnds) {
        List<MoviePlaying> moviesPlaying =
                moviePlayingRepo.getAllByDateEndsIsGreaterThanEqualAndDateStartsIsLessThanEqual(dateStarts,dateEnds);
        return getMoviesPlayingDTOsMin(moviesPlaying);
    }
}
