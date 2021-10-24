package cinema.shows.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "Price", nullable = false)
    private double price;

    @Column(name = "Seats_Number", nullable = false)
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "Shows_id", referencedColumnName = "id", nullable = false)
    private Show show;

}
