package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Basic@Column(name = "Tag", nullable = false, length = 45)
    private String tag;

    @ManyToOne
    @JoinColumn(name = "Theaters_id", referencedColumnName = "id", nullable = false)
    private Theater theater;

    @OneToMany(mappedBy = "hall")
    private List<Show> shows;

}
