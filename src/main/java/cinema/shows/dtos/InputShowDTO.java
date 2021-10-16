package cinema.shows.dtos;

import cinema.shows.entities.MoviePlayingPK;
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
public class InputShowDTO {
    private MoviePlayingPK moviePlayingPK;
    private Date date;
    private Time time;
    private int hallId;
}
