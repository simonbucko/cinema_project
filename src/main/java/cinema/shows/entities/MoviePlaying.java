package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "movies_playing")
public class MoviePlaying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Date_Starts", nullable = false)
    private Date dateStarts;

    @Column(name = "Date_Ends", nullable = false)
    private Date dateEnds;

    @ManyToOne
    @JoinColumn(name = "Movies_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "Theaters_id", referencedColumnName = "id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "moviePlaying")
    private List<Show> shows;

    public MoviePlaying(int id, Date dateStarts, Date dateEnds, Movie movie, Theater theater) {
        this.id = id;
        this.dateStarts = dateStarts;
        this.dateEnds = dateEnds;
        this.movie = movie;
        this.theater = theater;
    }

    public MoviePlaying(Date dateStarts, Date dateEnds, Movie movie, Theater theater) {
        this.dateStarts = dateStarts;
        this.dateEnds = dateEnds;
        this.movie = movie;
        this.theater = theater;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoviePlaying that)) return false;
        return Objects.equals(getMovie(), that.getMovie()) && Objects.equals(getTheater(), that.getTheater());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie(), getTheater());
    }
}
