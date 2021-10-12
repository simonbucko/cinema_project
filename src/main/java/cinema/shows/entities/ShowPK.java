package cinema.shows.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString
public class ShowPK implements Serializable {
    @Column(name = "id", nullable = false)@Id
    private int id;
    @Column(name = "Halls_id", nullable = false)@Id
    private int hallsId;

}
