package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column(name = "Halls_id", nullable = false)
    private int hallsId;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne
    @JoinColumn(name = "Movies_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "Halls_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Hall hall;

}
