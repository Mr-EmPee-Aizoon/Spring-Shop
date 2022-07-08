package ml.empee.angularShop.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
public final class ErrorDetails {

    @Getter
    private final Instant timestamp;
    @Getter
    private final String message;
    @Getter
    private final String details;

}
