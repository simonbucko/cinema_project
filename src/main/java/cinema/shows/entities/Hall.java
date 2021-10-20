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

    @Column(name = "Hall_Rows", nullable = false)
    private int hallRows;

    @Column(name = "Hall_Columns", nullable = false)
    private int hallColumns;

    @Column(name = "Hall_Name", nullable = false, length = 45)
    private String hallName;

    @Column(name = "Theaters_id", nullable = false)
    private int theater_id;

    @OneToMany(mappedBy = "hall")
    private List<Show> shows;

    public Hall(int id, int hallRows, int hallColumns, String hallName, int theater_id) {
        this.id = id;
        this.hallRows = hallRows;
        this.hallColumns = hallColumns;
        this.hallName = hallName;
        this.theater_id = theater_id;
    }

    public Hall(int hallRows, int hallColumns, String hallName, int theater_id) {
        this.hallRows = hallRows;
        this.hallColumns = hallColumns;
        this.hallName = hallName;
        this.theater_id = theater_id;
    }
}
