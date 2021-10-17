package cinema.shows.services;

import cinema.shows.dtos.ActorDTO;
import cinema.shows.entities.Actor;
import cinema.shows.repos.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorServicesImp implements ActorServices {
    private ActorRepo actorRepo;

    public ActorServicesImp(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    @Override
    public List<Actor> saveAll(List<ActorDTO> actorDTOList) {
        List<Actor> actorList = new ArrayList<>();
        for (ActorDTO a: actorDTOList) {
            Actor actor = new Actor(a);
            actorList.add(actor);
        }
        return actorRepo.saveAll(actorList);
    }
}
