package cinema.shows.utils;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.entities.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StaticCalls {

    public static List<ActorDTO> getListOfActorsToShowWithMovieRequest(Set<Actor> actors) {
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for (Actor a: actors) {
            ActorDTO actorDTO = new ActorDTO(a);
            actorDTOS.add(actorDTO);
        }
        return actorDTOS;
    }

}
