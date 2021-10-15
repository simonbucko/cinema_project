package cinema.shows.dtos;

import cinema.shows.entities.Actor;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditMovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Short minAge;
    private String description;
    private Integer categoryId;
    private List<Actor> actorList;
}
