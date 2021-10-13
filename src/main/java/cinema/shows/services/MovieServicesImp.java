package cinema.shows.services;

import cinema.shows.dtos.MovieDTO;
import cinema.shows.entities.Movie;
import cinema.shows.repos.MovieRepo;
import cinema.shows.staticCalls.StaticCalls;
import org.springframework.stereotype.Service;

@Service
public class MovieServicesImp implements MovieServices {
    private MovieRepo movieRepo;

    public MovieServicesImp(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movieToAdd = StaticCalls.movieFromMovieDTO(movieDTO);
        return new MovieDTO(movieRepo.save(movieToAdd));
    }

    @Override
    public MovieDTO getMovie(int id) {
        return new MovieDTO(movieRepo.getById(id));
    }

    @Override
    public MovieDTO updateMovie(MovieDTO movieDTO) {
        Movie movieInDB = movieRepo.getById(movieDTO.getId());
        String title = movieDTO.getTitle();
        Double rating = movieDTO.getRating();
        Short minAge = movieDTO.getMinAge();
        String description = movieDTO.getDescription();
        Integer categoryId = movieDTO.getCategoryId();
        if (title != null) {
            movieInDB.setTitle(title);
        }
        if (rating != null) {
            movieInDB.setRating(rating);
        }
        if (minAge != null) {
            movieInDB.setMinAge(minAge);
        }
        if (description != null) {
            movieInDB.setDescription(description);
        }
        if (categoryId != null) {
            movieInDB.setCategoryId(categoryId);
        }
        return new MovieDTO(movieRepo.save(movieInDB));
    }

    @Override
    public void removeMovie(int movieId) {
        movieRepo.deleteById(movieId);
    }

}
