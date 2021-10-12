package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "Name", nullable = false, length = 45)
    private String name;
}
