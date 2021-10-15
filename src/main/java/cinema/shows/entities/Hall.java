package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic@Column(name = "Tag", nullable = false, length = 45)
    private String tag;

    @OneToMany(mappedBy = "hall")
    private List<Show> showList;
}
