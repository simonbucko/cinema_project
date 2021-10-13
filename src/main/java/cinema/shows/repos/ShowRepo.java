package cinema.shows.repos;

import cinema.shows.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<Show, Integer> {

}
