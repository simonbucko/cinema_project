package cinema.shows.dtos;

import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import cinema.shows.staticCalls.StaticCalls;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Short minAge;
    private String description;
    private Integer categoryId;
    private List<ActorDTO> actorList;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.rating = movie.getRating();
        this.minAge = movie.getMinAge();
        this.description = movie.getDescription();
        this.categoryId = movie.getCategoryId();
        if (!movie.getActorSet().isEmpty()) {
            Set<Actor> actorSet = movie.getActorSet();
            this.actorList = StaticCalls.getListOfActorsToShowWithMovieRequest(actorSet);
        } else {
            this.actorList = new ArrayList<>();
        }
    }




}
