package cinema.shows.services;

import cinema.shows.dtos.InputShowDTO;
import cinema.shows.dtos.ShowDTOFUll;
import cinema.shows.dtos.ShowDTOMin;
import cinema.shows.repos.ShowRepo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ShowServicesImp implements ShowServices {
    private ShowRepo showRepo;

    public ShowServicesImp(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }

    @Override
    public ShowDTOMin addShow(InputShowDTO inputShowDTO) {
        return null;
    }

    @Override
    public ShowDTOMin updateShow(InputShowDTO inputShowDTO) {
        return null;
    }

    @Override
    public void removeShow(Integer movieId, Integer theaterId) {
    }

    @Override
    public ShowDTOFUll getShow(Integer movieId, Integer theaterId) {
        return null;
    }

    @Override
    public List<ShowDTOMin> getShowsByDate(Date date) {
        return null;
    }

    @Override
    public List<ShowDTOMin> getShowsByDates(Date dateStarts, Date dateEnds) {
        return null;
    }

    @Override
    public List<ShowDTOFUll> getShowsByMoviePlaying(Integer theaterId) {
        return null;
    }
}
