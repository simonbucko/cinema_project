package cinema.shows.services;

import cinema.shows.dtos.InputMoviePlayingDTO;
import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.entities.MoviePlayingPK;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingServices {
    MoviePlayingDTO addMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO);
    MoviePlayingDTO updateMoviePlayingInTheater(InputMoviePlayingDTO inputMoviePlayingDTO);
    void removeMoviePlayingInTheater(MoviePlayingPK moviePlayingPK);
    MoviePlayingDTO getMoviePlayingInTheater(MoviePlayingPK moviePlayingPK);
    List<MoviePlayingDTO> getAllMoviesPlayingInTheater(int theaterId);

    List<MoviePlayingDTO> getAllMoviesPlayingForDate(Date date);
    List<MoviePlayingDTO> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds);
}
