package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "movies_playing")
public class MoviePlaying {
    @EmbeddedId
    private MoviePlayingPK moviePlayingPK;

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

    @OneToMany(mappedBy = "moviePlaying")
    private List<Show> shows;

    public MoviePlaying(MoviePlayingPK moviePlayingPK, Date dateStarts, Date dateEnds) {
        this.moviePlayingPK = moviePlayingPK;
        this.dateStarts = dateStarts;
        this.dateEnds = dateEnds;
    }
}
