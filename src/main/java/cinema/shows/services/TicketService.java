package cinema.shows.services;

import cinema.shows.dtos.InputTicketDTO;
import cinema.shows.dtos.TicketDTOMin;

public interface TicketService {
    TicketDTOMin addTicket(InputTicketDTO ticketDTO);
}
