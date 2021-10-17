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

    @Column(name = "Tag", nullable = false, length = 45)
    private String tag;

    @Column(name = "Theaters_id", nullable = false)
    private int theaterId;

}
