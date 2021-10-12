package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "halls")
@IdClass(HallPK.class)
public class Hall {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Id@Column(name = "Theaters_id", nullable = false)
    private int theatersId;
    @Basic@Column(name = "Tag", nullable = false, length = 45)
    private String tag;

    @ManyToOne
    @JoinColumn(name = "Theaters_id", referencedColumnName = "id", nullable = false)
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "Halls_id", nullable = false)
    private Show show;

}
