package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Number", nullable = false)
    private long number;

    @Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Movies_Playing_Theaters_id", referencedColumnName = "Theaters_id", nullable = false),
            @JoinColumn(name = "Movies_Playing_Movies_id", referencedColumnName = "Movies_id", nullable = false)})
    private MoviePlaying moviePlaying;

    @ManyToOne
    @JoinColumn(name = "Halls_id", referencedColumnName = "id", nullable = false)
    private Hall hall;
}
