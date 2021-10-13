package cinema.shows.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoviesPlayingPK implements Serializable {
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
        MoviesPlayingPK that = (MoviesPlayingPK) o;
        return moviesId == that.moviesId && theatersId == that.theatersId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesId, theatersId);
    }
}
