package cinema.shows.staticCalls;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.dtos.MovieDTO;
import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StaticCalls {

    public static List<ActorDTO> getActorDTOs(Iterable<Actor> actors) {
        return StreamSupport.stream(actors.spliterator(), false)
                .map(actor -> new ActorDTO(actor))
                .collect(Collectors.toList());
    }

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
                Actor actor = new Actor(a);
                actorList.add(actor);
            }
            movie.setActorList(actorList);
        }
        return movie;
    }
}
