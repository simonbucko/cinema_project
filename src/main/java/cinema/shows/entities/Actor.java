package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "actors")
public class Actor {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "First_Name", nullable = false, length = 45)
    private String firstName;
    @Basic@Column(name = "Last_Name", nullable = false, length = 45)
    private String lastName;

    @ManyToMany(mappedBy = "actorList", fetch = FetchType.LAZY)
    private List<Movie> movieList;
}
