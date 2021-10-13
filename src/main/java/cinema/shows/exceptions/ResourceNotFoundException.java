package cinema.shows.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L; //this is used for versioning of classes

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
