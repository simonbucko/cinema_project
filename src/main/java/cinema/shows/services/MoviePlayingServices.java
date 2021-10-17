package cinema.shows.services;

import cinema.shows.dtos.InputMoviePlayingDTO;
import cinema.shows.dtos.MoviePlayingDTOFull;
import cinema.shows.dtos.MoviePlayingDTOMin;
import cinema.shows.entities.MoviePlayingPK;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingServices {
    MoviePlayingDTOMin addMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO);
    MoviePlayingDTOMin updateMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO);
    void removeMoviePlayingInTheater(Integer movieId, Integer theaterId);

    MoviePlayingDTOFull getMoviePlayingInTheater(Integer movieId, Integer theaterId);
    List<MoviePlayingDTOMin> getAllMinMoviesPlayingInTheater(Integer theaterId);
    List<MoviePlayingDTOMin> getAllMinMoviesPlayingForDate(Date date);
    List<MoviePlayingDTOMin> getAllMinMoviesPlayingForDates(Date dateStarts, Date dateEnds);

    MoviePlayingDTOMin getMinMoviePlayingInTheater(Integer movieId, Integer theaterId);
    List<MoviePlayingDTOFull> getAllMoviesPlayingInTheater(Integer theaterId);
    List<MoviePlayingDTOFull> getAllMoviesPlayingForDate(Date date);
    List<MoviePlayingDTOFull> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds);
}
