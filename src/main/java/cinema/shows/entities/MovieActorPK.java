package cinema.shows.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class MovieActorPK implements Serializable {
    @Column(name = "Movies_id", nullable = false)@Id
    private int moviesId;
    @Column(name = "Actors_id", nullable = false)@Id
    private int actorsId;

}
