package cinema.shows.repos;

import cinema.shows.entities.Show;
import cinema.shows.entities.ShowPK;
import cinema.shows.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ShowRepo extends JpaRepository<Show, ShowPK> {
    List<Show> getAllByDateIs(Date date);
    List<Show> getAllByDateIsBetween(Date dateOne, Date dateTwo);
    List<Show> getAllByMoviePlaying_TheaterIs(Theater theater);
    List<Show> getAllByDateIsAndMoviePlaying_TheaterIs(Date date, Theater theater);
    List<Show> getAllByDateIsBetweenAndMoviePlaying_TheaterIs(Date dateOne, Date dateTwo, Theater theater);
}
