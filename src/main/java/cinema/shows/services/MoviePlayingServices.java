package cinema.shows.services;

import cinema.shows.dtos.MoviePlayingDTO;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingServices {
    List<MoviePlayingDTO> getAllMoviesPlayingForDate(Date date);
    List<MoviePlayingDTO> getAllMoviesPlayingForDates(Date dateStarts, Date dateEnds);
}
