package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "theaters")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Street", nullable = false, length = 45)
    private String street;

    @Column(name = "City", nullable = false, length = 45)
    private String city;

    @Column(name = "Zipcode", nullable = false)
    private short zipcode;

    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MoviePlaying moviePlaying;

    @OneToMany(mappedBy = "theater")
    private List<Hall> halls;
}
