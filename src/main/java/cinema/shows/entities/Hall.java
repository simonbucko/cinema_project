package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column(name = "Theaters_id", nullable = false)
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
