package ml.empee.angularShop.exceptions.handlers;

import ml.empee.angularShop.exceptions.ErrorDetails;
import ml.empee.angularShop.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.Arrays;

@ControllerAdvice
public class GeneralExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger("MyApp");

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(Instant.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        String errorMessage = "Unhandled error\n" +
                                "Incoming request: " + request.getDescription(false) + "\n" +
                                "Message: " + ex.getMessage() + "\n" +
                                "Stacktrace:\n" + Arrays.toString(ex.getStackTrace());
        logger.error(errorMessage);

        ErrorDetails errorDetails = new ErrorDetails(Instant.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
