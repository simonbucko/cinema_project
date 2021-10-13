package cinema.shows.services;

import cinema.shows.repos.ActorRepo;
import org.springframework.stereotype.Service;

@Service
public class ActorServicesImp implements ActorServices {
    private ActorRepo actorRepo;

    public ActorServicesImp(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

}
