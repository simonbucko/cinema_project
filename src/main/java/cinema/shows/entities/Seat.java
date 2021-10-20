package cinema.shows.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @Column(name = "Number", nullable = false, length = 45)
    private int number;

    @Column(name = "Seat_Row", nullable = false)
    private int seatRow;

    @Column(name = "Seat_Column", nullable = false)
    private String seatColumn;
}
