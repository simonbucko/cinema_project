package cinema.shows.dtos;

import cinema.shows.entities.MoviePlayingPK;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoviePlayingDTO {
    private MovieDTO movieDTO;
    private Date dateStarts;
    private Date dateEnds;
    private MoviePlayingPK moviePlayingPK;
}
