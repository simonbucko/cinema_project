package cinema.shows.repos;

import cinema.shows.entities.MoviesPlaying;
import cinema.shows.entities.MoviesPlayingPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface MoviesPlayingRepo extends JpaRepository<MoviesPlaying, MoviesPlayingPK> {
    List<MoviesPlaying> getAllByDate(Date date);
    List<MoviesPlaying> getAllByDateStartsAndDateEnds(Date dateStarts, Date dateEnds);
}
