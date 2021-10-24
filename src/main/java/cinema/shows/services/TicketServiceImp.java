package cinema.shows.services;

import cinema.shows.dtos.InputTicketDTO;
import cinema.shows.dtos.TicketDTOMin;
import cinema.shows.repos.TicketRepo;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {
    private TicketRepo ticketRepo;

    public TicketServiceImp(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    @Override
    public TicketDTOMin addTicket(InputTicketDTO ticketDTO) {
        return null;
    }
}
