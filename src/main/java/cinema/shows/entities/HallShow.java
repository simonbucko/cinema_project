package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "hall_shows")
@IdClass(HallShowPK.class)
public class HallShow {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "Hall_id", nullable = false)
    private int hallId;
    @Id@Column(name = "Shows_id", nullable = false)
    private int showsId;

}
