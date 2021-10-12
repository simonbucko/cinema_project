package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Data
@Entity
@Table(name = "theaters")
public class Theater {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "Street", nullable = false, length = 45)
    private String street;
    @Basic@Column(name = "City", nullable = false, length = 45)
    private String city;
    @Basic@Column(name = "Zipcode", nullable = false)
    private short zipcode;
    @OneToMany(mappedBy = "theatersByTheatersId")
    private Collection<Hall> hallsById;
}
