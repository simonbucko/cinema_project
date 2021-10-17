package cinema.shows.services;

import cinema.shows.dtos.*;

import java.sql.Date;
import java.util.List;

public interface ShowServices {
    ShowDTOMin addShow(InputShowDTO inputShowDTO);
    ShowDTOMin updateShow(InputShowDTO inputShowDTO);
    void removeShow(Integer movieId, Integer theaterId);
    ShowDTOFUll getShow(Integer movieId, Integer theaterId);

    List<ShowDTOMin> getShowsByDate(Date date);
    List<ShowDTOMin> getShowsByDates(Date dateStarts, Date dateEnds);
    List<ShowDTOFUll> getShowsByMoviePlaying(Integer theaterId);

}
