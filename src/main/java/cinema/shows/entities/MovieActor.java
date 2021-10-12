package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "movie_actors")
@IdClass(MovieActorPK.class)
public class MovieActor {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "Movies_id", nullable = false)
    private int moviesId;
    @Id@Column(name = "Actors_id", nullable = false)
    private int actorsId;

}
