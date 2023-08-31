package de.imker.handler;


import de.imker.dto.ErrorDto;
import de.imker.exeptions.RestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionsHandler {

        @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorDto> handleRestException(RestException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ErrorDto.builder()
                        .message(e.getMessage())
                        .build());
    }
}