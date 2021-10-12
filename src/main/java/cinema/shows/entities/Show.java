package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column(name = "Halls_id", nullable = false)
    private int hallsId;

    @Basic@Column(name = "Date", nullable = false)
    private Date date;

    @Basic@Column(name = "Time", nullable = false)
    private Time time;

    @ManyToOne
    @JoinColumn(name = "Movies_id", referencedColumnName = "id", nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "show")
    private List<Hall> halls;

}
