package cinema.shows.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class MoviePlayingPK implements Serializable {
    @Column(name = "Movies_id", nullable = false)
    private int moviesId;
    public int getMoviesId() {
        return moviesId;
    }
    public void setMoviesId(int moviesId) {
        this.moviesId = moviesId;
    }

    @Column(name = "Theaters_id", nullable = false)
    private int theatersId;
    public int getTheatersId() {
        return theatersId;
    }
    public void setTheatersId(int theatersId) {
        this.theatersId = theatersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviePlayingPK that = (MoviePlayingPK) o;
        return moviesId == that.moviesId && theatersId == that.theatersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesId, theatersId);
    }

    public MoviePlayingPK(int moviesId, int theatersId) {
        this.moviesId = moviesId;
        this.theatersId = theatersId;
    }
}
