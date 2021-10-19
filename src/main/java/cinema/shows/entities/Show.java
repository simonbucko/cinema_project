package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne
    @JoinColumn(name = "Movies_Playing_id", referencedColumnName = "id", nullable = false)
    private MoviePlaying moviePlaying;

    @ManyToOne
    @JoinColumn(name = "Halls_id", referencedColumnName = "id", nullable = false)
    private Hall hall;

    @OneToMany(mappedBy = "show")
    private List<Ticket> tickets;

    public Show(Date date, Time time, MoviePlaying moviePlaying, Hall hallId) {
        this.date = date;
        this.time = time;
        this.moviePlaying = moviePlaying;
        this.hall = hallId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show show)) return false;
        return getHall() == show.getHall() && Objects.equals(getDate(), show.getDate()) && Objects.equals(getTime(), show.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getTime(), getHall());
    }
}
