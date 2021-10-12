package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "First_Name", nullable = false, length = 45)
    private String firstName;
    @Basic@Column(name = "Last_Name", nullable = false, length = 45)
    private String lastName;

}
