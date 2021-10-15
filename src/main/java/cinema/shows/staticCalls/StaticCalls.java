package cinema.shows.staticCalls;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.dtos.InputMovieDTO;
import cinema.shows.dtos.MovieDTO;
import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.entities.Actor;
import cinema.shows.entities.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StaticCalls {

//    public static List<ActorDTO> getActorDTOs(Iterable<Actor> actors) {
//        return StreamSupport.stream(actors.spliterator(), false)
//                .map(actor -> new ActorDTO(actor))
//                .collect(Collectors.toList());
//    }
    public static List<ActorDTO> getActorDTOs(Iterable<Actor> actors) {
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for (Actor a: actors) {
            actorDTOS.add(new ActorDTO(a));
        }
        return actorDTOS;
    }


//    public static List<Actor> getActors(Iterable<ActorDTO> actorDTOS) {
//        return StreamSupport.stream(actorDTOS.spliterator(), false)
//                .map(actorDTO -> new Actor(actorDTO))
//                .collect(Collectors.toList());
//    }

    public static List<Actor> getActors(Iterable<ActorDTO> actorsDTOs) {
        List<Actor> actors = new ArrayList<>();
        for (ActorDTO a: actorsDTOs) {
            actors.add(new Actor(a));
        }
        return actors;
    }

    public static Movie movieFromMovieDTO(InputMovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setRating(movieDTO.getRating());
        movie.setMinAge(movieDTO.getMinAge());
        movie.setDescription(movieDTO.getDescription());
        movie.setCategoryId(movieDTO.getCategoryId());
        if (movieDTO.getActorList() == null) {
            return movie;
        }
        if (movieDTO.getActorList().size() == 0) {
            return movie;
        }
        if (!movieDTO.getActorList().get(1).getFirstName().equals("String") &&
                !movieDTO.getActorList().get(1).getLastName().equals("String")) {
            List<Actor> actorList = new ArrayList<>();
            for (ActorDTO a : movieDTO.getActorList()) {
                Actor actor = new Actor(a);
                actorList.add(actor);
            }
            Set<Actor> actors = new HashSet<>(actorList);
            movie.setActorList(actors);
        }
        return movie;
    }

}
