package cinema.shows.staticCalls;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.entities.Actor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ActorEx {
    public static Actor actorFromActorDTO(ActorDTO actorDTO) {
        return new Actor(actorDTO.getFirstName(),actorDTO.getLastName());
    }

    public static List<ActorDTO> getActorDTOs(Iterable<Actor> actors) {
        return StreamSupport.stream(actors.spliterator(), false)
                .map(actor -> new ActorDTO(actor))
                .collect(Collectors.toList());
    }
}
