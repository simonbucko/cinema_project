package cinema.shows.entities;

import cinema.shows.dtos.ActorDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "actors")
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "First_Name", length = 45)
    private String firstName;

    @Column(name = "Last_Name", length = 45)
    private String lastName;

    @ManyToMany(mappedBy = "actorList")
    private List<Movie> movieList;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor(ActorDTO actorDTO) {
        this.firstName = actorDTO.getFirstName();
        this.lastName = actorDTO.getLastName();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
        movie.getActorList().add(this);
    }
}
