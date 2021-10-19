package cinema.shows.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "Rows", nullable = false)
    private int rows;

    @Column(name = "Columns", nullable = false)
    private int columns;

    @Column(name = "Theaters_id", nullable = false)
    private int theater_id;

    @OneToMany(mappedBy = "hallId")
    private List<Show> shows;

    public Hall(int id, String tag, int rows, int columns, int theater_id) {
        this.id = id;
        this.tag = tag;
        this.rows = rows;
        this.columns = columns;
        this.theater_id = theater_id;
    }
}
