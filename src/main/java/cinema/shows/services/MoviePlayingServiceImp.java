package cinema.shows.services;

import cinema.shows.repos.MoviePlayingRepo;
import org.springframework.stereotype.Service;

@Service
public class MoviePlayingServiceImp implements MoviePlayingService {
    private MoviePlayingRepo moviePlayingRepo;

    public MoviePlayingServiceImp(MoviePlayingRepo moviePlayingRepo) {
        this.moviePlayingRepo = moviePlayingRepo;
    }
}
