package cinema.shows.dtos;

import cinema.shows.entities.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTOMin {
    private Integer id;
    private String title;
    private Short minAge;

    public MovieDTOMin(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.minAge = movie.getMinAge();
    }
}
