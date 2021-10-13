package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "movies_playing")
public class MoviesPlaying {
    @EmbeddedId
    private MoviesPlayingPK moviesPlayingPK;

    @Column(name = "Date_Starts", nullable = false)
    private Date dateStarts;

    @Column(name = "Date_Ends", nullable = false)
    private Date dateEnds;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Movies_id", nullable = false, insertable = false, updatable = false)
    private Movie movie;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Theaters_id", nullable = false, insertable = false, updatable = false)
    private Theater theater;
}
