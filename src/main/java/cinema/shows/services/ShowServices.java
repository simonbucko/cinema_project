package cinema.shows.services;

import cinema.shows.dtos.*;
import cinema.shows.entities.Show;

import java.sql.Date;
import java.util.List;

public interface ShowServices {
    Show getShow(Integer moviePlayingId, Integer theaterId);

    ShowDTOMin addShow(InputShowDTO inputShowDTO);
    ShowDTOMin updateShow(InputShowDTO inputShowDTO);
    void removeShow(Integer movieId, Integer theaterId);
    ShowDTOMin getMinShow(Integer movieId, Integer theaterId);

    List<ShowDTOMin> getMinShowsByDate(Date date);
    List<ShowDTOMin> getMinShowsByDates(Date dateStarts, Date dateEnds);
    List<ShowDTOMin> getMinShowsByTheater(Integer theaterId);

    List<ShowDTOMin> getMinShowsByDateAndTheater(Date date, Integer theaterId);
    List<ShowDTOMin> getMinShowsByDatesAndTheater(Date dateOne, Date dateTwo, Integer theaterId);

    List<ShowDTOFull> getShowsByDateAndTheater(Date date, Integer theaterId);
    List<ShowDTOFull> getShowsByDatesAndTheater(Date date, Date dateTwo, Integer theaterId);

}
