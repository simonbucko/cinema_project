package cinema.shows.services;

import cinema.shows.dtos.InputShowDTO;
import cinema.shows.dtos.MoviePlayingDTOMin;
import cinema.shows.dtos.ShowDTOFull;
import cinema.shows.dtos.ShowDTOMin;
import cinema.shows.entities.*;
import cinema.shows.exceptions.ResourceNotFoundException;
import cinema.shows.repos.HallRepo;
import cinema.shows.repos.ShowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class ShowServicesImp implements ShowServices {
    private ShowRepo showRepo;
    @Autowired
    HallRepo hallRepo;
    @Autowired
    MoviePlayingServices moviePlayingServices;

    public ShowServicesImp(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }

    private String errorMessage(Integer movieId, Integer theaterId){
        return "Movie Playing NOT FOUND with movieId = " + movieId + " and theaterId = " + theaterId;
    }

    @Override
    public Show getShow(Integer moviePlayingId, Integer theaterId) {
        return showRepo.findById(new ShowPK(moviePlayingId,theaterId))
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage(moviePlayingId,theaterId)));
    }

    private Show getShowFromInputShowDTO(InputShowDTO inputShowDTO) {
        Show show = new Show();
        show.setShowPK(new ShowPK(inputShowDTO.getMoviePlayingId(),inputShowDTO.getTheaterId()));
        show.setDate(inputShowDTO.getDate());
        show.setTime(inputShowDTO.getTime());
        Hall hall = hallRepo.getById(inputShowDTO.getHallId());
        show.setHall(hall);
        return show;
    }

    private ShowDTOMin getShowDTOMinFromShow(Show show) {
        ShowDTOMin showDTOMin = new ShowDTOMin();
        showDTOMin.setDate(show.getDate());
        showDTOMin.setTime(show.getTime());
        ShowPK showPK = show.getShowPK();
        int moviePlayingId = showPK.getMoviesPlayingMoviesId();
        int theaterId = showPK.getMoviesPlayingTheatersId();
        MoviePlayingDTOMin moviePlayingDTOMin =
                moviePlayingServices.getMinMoviePlayingInTheater(moviePlayingId,theaterId);
        showDTOMin.setMoviePlayingDTOMin(moviePlayingDTOMin);
        return showDTOMin;
    }

    @Override
    public ShowDTOMin addShow(InputShowDTO inputShowDTO) {
        Show newShow = getShowFromInputShowDTO(inputShowDTO);
        Show showSaved = showRepo.save(newShow);
        return getShowDTOMinFromShow(showSaved);
    }

    @Override
    public ShowDTOMin updateShow(InputShowDTO inputShowDTO) {
        Integer moviePlayingId = inputShowDTO.getMoviePlayingId();
        Integer theaterId = inputShowDTO.getTheaterId();
        Show showInDB = getShow(moviePlayingId,theaterId);
        Date date = inputShowDTO.getDate();
        Time time = inputShowDTO.getTime();
        Integer hallId = inputShowDTO.getHallId();
        if (date != null) {
            showInDB.setDate(date);
        }
        if (time != null) {
            showInDB.setTime(time);
        }
        if (hallId != null) {
            Hall hall = hallRepo.getById(hallId);
            showInDB.setHall(hall);
        }
        Show showSaved = showRepo.save(showInDB);
        return getShowDTOMinFromShow(showSaved);
    }

    @Override
    public void removeShow(Integer movieId, Integer theaterId) {
        getShow(movieId,theaterId);
        showRepo.deleteById(new ShowPK(movieId,theaterId));
    }

    @Override
    public ShowDTOMin getMinShow(Integer movieId, Integer theaterId) {
        Show show = getShow(movieId,theaterId);
        return getShowDTOMinFromShow(show);
    }

    @Override
    public List<ShowDTOMin> getMinShowsByDate(Date date) {
        return null;
    }

    @Override
    public List<ShowDTOMin> getMinShowsByDates(Date dateStarts, Date dateEnds) {
        return null;
    }

    @Override
    public List<ShowDTOMin> getMinShowsByTheater(Integer theaterId) {
        return null;
    }

    @Override
    public List<ShowDTOFull> getShowsByDate(Date date) {
        return null;
    }

    @Override
    public List<ShowDTOFull> getShowsByDates(Date dateStarts, Date dateEnds) {
        return null;
    }

    @Override
    public List<ShowDTOFull> getShowsByMoviePlaying(Integer theaterId) {
        return null;
    }
}
