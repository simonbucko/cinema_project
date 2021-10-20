package cinema.shows.repos;

import cinema.shows.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
}
