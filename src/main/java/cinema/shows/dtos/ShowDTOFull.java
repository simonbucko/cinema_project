package cinema.shows.dtos;

import cinema.shows.entities.Hall;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDTOFull {
    private MoviePlayingDTOFull moviePlayingDTOFull;
    private Time time;
    private Date date;
    private Hall hall;
    private String hallId;
}
