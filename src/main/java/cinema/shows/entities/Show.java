package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "shows")
public class Show {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "Date", nullable = false)
    private Date date;
    @Basic@Column(name = "Time", nullable = false)
    private Time time;
    @OneToMany(mappedBy = "showsByShowsId")
    private Collection<HallShow> hallShowsById;
    @ManyToOne@JoinColumn(name = "Movies_id", referencedColumnName = "id", nullable = false)
    private Movie moviesByMoviesId;

}
