package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shows")
public class Show {
    @EmbeddedId
    private ShowPK showPK;

    @Column(name = "Time", nullable = false)
    private Time time;

    @Column(name = "Date", nullable = false)
    private Date date;

    @Column(name = "Halls_id", nullable = false)
    private int hallId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "Movies_Playing_Theaters_id", referencedColumnName = "Theaters_id", nullable = false,
                    insertable = false, updatable = false),
            @JoinColumn(name = "Movies_Playing_Movies_id", referencedColumnName = "Movies_id", nullable = false,
                    insertable = false, updatable = false)})
    private MoviePlaying moviePlaying;

    public Show(ShowPK showPK, Time time, Date date, int hallId) {
        this.showPK = showPK;
        this.time = time;
        this.date = date;
        this.hallId = hallId;
    }
}
