package cinema.shows.services;

import cinema.shows.repos.ShowRepo;
import org.springframework.stereotype.Service;

@Service
public class ShowServicesImp implements ShowServices {
    private ShowRepo showRepo;

    public ShowServicesImp(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }
}
