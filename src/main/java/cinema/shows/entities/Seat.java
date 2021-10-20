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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Number", nullable = false, length = 45)
    private int number;

    @Column(name = "row", nullable = false)
    private short row;

    @Column(name = "column", nullable = false)
    private String column;
}
