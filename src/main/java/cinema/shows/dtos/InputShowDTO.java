package cinema.shows.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputShowDTO {
    private Integer moviePlayingId;
    private Integer theaterId;
    private String date;
    private String time;
    private Integer hallId;
    private String datePattern = "yyyy-MM-dd";
    private String timePattern = "hh:mm:ss";
}
