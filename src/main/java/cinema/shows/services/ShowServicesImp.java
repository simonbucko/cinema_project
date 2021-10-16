package cinema.shows.services;

import cinema.shows.dtos.MoviePlayingDTO;
import cinema.shows.dtos.ShowDTO;
import cinema.shows.repos.ShowRepo;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class ShowServicesImp implements ShowServices {
    private ShowRepo showRepo;

    public ShowServicesImp(ShowRepo showRepo) {
        this.showRepo = showRepo;
    }

    @Override
    public ShowDTO addShow(MoviePlayingDTO moviePlayingDTO, Time time, int hallId) {
        return null;
    }

    @Override
    public ShowDTO updateShow() {
        return null;
    }

    @Override
    public void removeShow() {

    }

    @Override
    public List<ShowDTO> getShowsByDate() {
        return null;
    }

    @Override
    public List<ShowDTO> getShowsByDates() {
        return null;
    }

    @Override
    public List<ShowDTO> getShowsByMoviePlaying() {
        return null;
    }
}
