package cinema.shows.services;

import cinema.shows.repos.MovieRepo;
import org.springframework.stereotype.Service;

@Service
public class MovieServicesImp implements MovieServices {
    private MovieRepo movieRepo;

    public MovieServicesImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
}
