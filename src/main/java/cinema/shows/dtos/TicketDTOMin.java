package cinema.shows.dtos;

import cinema.shows.entities.Seat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDTOMin {
    private ShowDTOMin showDTOMin;
    private Seat seat;
    private double price;
}
