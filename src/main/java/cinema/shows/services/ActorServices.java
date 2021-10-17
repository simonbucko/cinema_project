package cinema.shows.services;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.entities.Actor;

import java.util.List;

public interface ActorServices {
    List<Actor> saveAll(List<ActorDTO> actorDTOList);
}
