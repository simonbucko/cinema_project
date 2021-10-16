package cinema.shows.services;

import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.dtos.ShowDTO;

import java.sql.Time;
import java.util.List;

public interface ShowServices {
    ShowDTO addShow(MoviePlayingDTO moviePlayingDTO, Time time, int hallId);
    ShowDTO updateShow();
    void removeShow();

    List<ShowDTO> getShowsByDate();
    List<ShowDTO> getShowsByDates();
    List<ShowDTO> getShowsByMoviePlaying();

}
