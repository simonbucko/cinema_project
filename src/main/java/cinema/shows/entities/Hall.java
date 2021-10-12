package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "halls")
public class Hall {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "Theaters_id", nullable = false)
    private int theatersId;
    @Basic@Column(name = "Tag", nullable = false, length = 45)
    private String tag;
    @OneToMany(mappedBy = "hallsByHallId")
    private Collection<HallShow> hallShowsById;

}
