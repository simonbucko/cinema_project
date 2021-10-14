package cinema.shows.repos;

import cinema.shows.entities.MoviePlaying;
import cinema.shows.entities.MoviePlayingPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface MoviePlayingRepo extends JpaRepository<MoviePlaying, MoviePlayingPK> {
    List<MoviePlaying> getAllByDateEndsIsLessThan(Date date);
    List<MoviePlaying> getAllByDateEndsIsBetween(Date dateGivenStart, Date dateGivenEnd);
    List<MoviePlaying> getAllByDateStartsIsGreaterThanAndDateEndsIsBefore();
    List<MoviePlaying> getAllByDateEndsIsNotInAndDateStartsIsNot();
}
