package cinema.shows.entities;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class ShowPK implements Serializable {
    @Column(name = "Movies_Playing_Theaters_id", nullable = false)
    private int moviesPlayingTheatersId;
    public int getMoviesPlayingTheatersId() {
        return moviesPlayingTheatersId;
    }

    public void setMoviesPlayingTheatersId(int moviesPlayingTheatersId) {
        this.moviesPlayingTheatersId = moviesPlayingTheatersId;
    }

    @Column(name = "Movies_Playing_Movies_id", nullable = false)
    private int moviesPlayingMoviesId;
    public int getMoviesPlayingMoviesId() {
        return moviesPlayingMoviesId;
    }

    public void setMoviesPlayingMoviesId(int moviesPlayingMoviesId) {
        this.moviesPlayingMoviesId = moviesPlayingMoviesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowPK showPK = (ShowPK) o;
        return moviesPlayingTheatersId == showPK.moviesPlayingTheatersId && moviesPlayingMoviesId == showPK.moviesPlayingMoviesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesPlayingTheatersId, moviesPlayingMoviesId);
    }
}
