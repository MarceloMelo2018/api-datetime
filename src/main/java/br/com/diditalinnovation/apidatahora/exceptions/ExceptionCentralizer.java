package br.com.diditalinnovation.apidatahora.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.zone.ZoneRulesException;

// Centralizes all error handling for the user
@RestControllerAdvice
public class ExceptionCentralizer {

    private Error buildError(RuntimeException e) {
        return Error.newBuilder()
                .withDateTimeError(LocalDateTime.now())
                .withMessage(e.getMessage());
    }

    @ExceptionHandler(ZoneRulesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleZoneRulesException(ZoneRulesException e) {
        return buildError(new RuntimeException("Please, provide a valid timezone!"));
    }

    @ExceptionHandler(DateTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleZoneRulesException(DateTimeException e) {
        return buildError(new RuntimeException("Timezone with invalid format!"));
    }
}