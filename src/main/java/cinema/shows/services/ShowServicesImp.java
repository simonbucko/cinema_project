package cinema.shows.services;

import cinema.shows.dtos.*;
import cinema.shows.entities.*;
import cinema.shows.exceptions.ResourceNotFoundException;
import cinema.shows.repos.HallRepo;
import cinema.shows.repos.ShowRepo;
import cinema.shows.repos.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServicesImp implements ShowServices {
    private ShowRepo showRepo;
    @Autowired
    HallRepo hallRepo;
    @Autowired
    MoviePlayingServices moviePlayingServices;
    @Autowired
    TheaterRepo theaterRepo;

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
        show.setDate(Date.valueOf(inputShowDTO.getDate()));
        show.setTime(Time.valueOf(inputShowDTO.getTime()));
        show.setHallId(inputShowDTO.getHallId());
        return show;
    }
    private ShowDTOMin getShowDTOMinFromShow(Show show) {
        ShowDTOMin showDTOMin = new ShowDTOMin();
        showDTOMin.setDate(show.getDate());
        showDTOMin.setTime(show.getTime().toString());
        ShowPK showPK = show.getShowPK();
        int moviePlayingId = showPK.getMoviesPlayingMoviesId();
        int theaterId = showPK.getMoviesPlayingTheatersId();
        MoviePlayingDTOMin moviePlayingDTOMin =
                moviePlayingServices.getMinMoviePlayingInTheater(moviePlayingId,theaterId);
        showDTOMin.setMoviePlayingDTOMin(moviePlayingDTOMin);
        String hall = hallRepo.getById(show.getHallId()).getTag();
        showDTOMin.setHall(hall);
        return showDTOMin;
    }
    private List<ShowDTOMin> getShowDTOsMinFromShows(List<Show> shows) {
        List<ShowDTOMin> showDTOsMin = new ArrayList<>();
        for (Show s: shows) {
            showDTOsMin.add(getShowDTOMinFromShow(s));
        }
        return showDTOsMin;
    }
    private ShowDTOFull getShowDTOFullFromShow(Show show) {
        ShowDTOFull showDTOFull = new ShowDTOFull();
        showDTOFull.setDate(show.getDate());
        showDTOFull.setTime(show.getTime());
        ShowPK showPK = show.getShowPK();
        int moviePlayingId = showPK.getMoviesPlayingMoviesId();
        int theaterId = showPK.getMoviesPlayingTheatersId();
        MoviePlayingDTOFull moviePlayingDTOFull =
                moviePlayingServices.getMoviePlayingInTheater(moviePlayingId,theaterId);
        String hall = hallRepo.getById(show.getHallId()).getTag();
        showDTOFull.setHall(hall);
        showDTOFull.setMoviePlayingDTOFull(moviePlayingDTOFull);
        return showDTOFull;
    }
    private List<ShowDTOFull> getShowDTOsFullFromShows(List<Show> shows) {
        List<ShowDTOFull> showDTOsFull = new ArrayList<>();
        for (Show s: shows) {
            showDTOsFull.add(getShowDTOFullFromShow(s));
        }
        return showDTOsFull;
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
        Date date = Date.valueOf(inputShowDTO.getDate());
        Time time = Time.valueOf(inputShowDTO.getTime());
        Integer hallId = inputShowDTO.getHallId();
        if (date != null) {
            showInDB.setDate(date);
        }
        if (time != null) {
            showInDB.setTime(time);
        }
        if (hallId != null) {
            showInDB.setHallId(hallId);
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
        List<Show> shows = showRepo.getAllByDateIs(date);
        return getShowDTOsMinFromShows(shows);
    }

    @Override
    public List<ShowDTOMin> getMinShowsByDates(Date dateStarts, Date dateEnds) {
        List<Show> shows = showRepo.getAllByDateIsBetween(dateStarts,dateEnds);
        return getShowDTOsMinFromShows(shows);
    }

    @Override
    public List<ShowDTOMin> getMinShowsByTheater(Integer theaterId) {
        Theater theater = theaterRepo.getById(theaterId);
        List<Show> shows = showRepo.getAllByMoviePlaying_TheaterIs(theater);
        return getShowDTOsMinFromShows(shows);
    }

    @Override
    public List<ShowDTOMin> getMinShowsByDateAndTheater(Date date, Integer theaterId) {
        Theater theater = theaterRepo.getById(theaterId);
        List<Show> shows = showRepo.getAllByDateIsAndMoviePlaying_TheaterIs(date, theater);
        return getShowDTOsMinFromShows(shows);
    }

    @Override
    public List<ShowDTOMin> getMinShowsByDatesAndTheater(Date dateOne, Date dateTwo, Integer theaterId) {
        Theater theater = theaterRepo.getById(theaterId);
        List<Show> shows = showRepo.getAllByDateIsBetweenAndMoviePlaying_TheaterIs(dateOne,dateTwo,theater);
        return getShowDTOsMinFromShows(shows);
    }

    @Override
    public List<ShowDTOFull> getShowsByDateAndTheater(Date date, Integer theaterId) {
        Theater theater = theaterRepo.getById(theaterId);
        List<Show> shows = showRepo.getAllByDateIsAndMoviePlaying_TheaterIs(date, theater);
        return getShowDTOsFullFromShows(shows);
    }

    @Override
    public List<ShowDTOFull> getShowsByDatesAndTheater(Date dateOne, Date dateTwo, Integer theaterId) {
        Theater theater = theaterRepo.getById(theaterId);
        List<Show> shows = showRepo.getAllByDateIsBetweenAndMoviePlaying_TheaterIs(dateOne,dateTwo,theater);
        return getShowDTOsFullFromShows(shows);
    }
}
