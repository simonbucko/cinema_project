package cinema.shows.staticCalls;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.dtos.MovieDTO;
import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;
import cinema.shows.services.ActorServicesImp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieEx {

    public static Movie movieFromMovieDTO(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setRating(movieDTO.getRating());
        movie.setMinAge(movieDTO.getMinAge());
        movie.setDescription(movieDTO.getDescription());
        movie.setCategoryId(movieDTO.getCategoryId());
        if (movieDTO.getActorList() != null) {
            List<Actor> actorList = new ArrayList<>();
            for (ActorDTO a : movieDTO.getActorList()) {
                Actor actor = ActorEx.actorFromActorDTO(a);
                actorList.add(actor);
            }
            movie.setActorList(actorList);
        }
        return movie;
    }
}
