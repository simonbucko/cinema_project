package cinema.shows.entities;

import cinema.shows.dtos.ActorDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(mappedBy = "actorSet")
    private Set<Movie> movieSet;

    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Actor(ActorDTO actorDTO) {
        this.firstName = actorDTO.getFirstName();
        this.lastName = actorDTO.getLastName();
    }

    public void addMovie(Movie movie) {
        movieSet.add(movie);
        movie.getActorSet().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return getFirstName().equals(actor.getFirstName()) && getLastName().equals(actor.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }
}
