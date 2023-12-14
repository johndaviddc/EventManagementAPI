package dave.dev.eventmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RsvpNotFoundException extends RuntimeException {
    public RsvpNotFoundException(String message) {
        super(message);
    }
}
