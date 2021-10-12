package cinema.shows.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class HallShowPK implements Serializable {
    @Column(name = "Hall_id", nullable = false)@Id
    private int hallId;
    @Column(name = "Shows_id", nullable = false)@Id
    private int showsId;

}
