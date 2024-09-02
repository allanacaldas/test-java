package br.com.blz.testjava.exception;

import br.com.blz.testjava.data.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerConfig {

    private static final String UNKNOWN_ERROR_MESSAGE = "Ocorreu um erro inesperado. Tente novamente mais tarde";

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(buildError(HttpStatus.NOT_FOUND.value(),UNKNOWN_ERROR_MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(DuplicatedProductException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatedProductException(DuplicatedProductException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(buildError(HttpStatus.UNPROCESSABLE_ENTITY.value(),UNKNOWN_ERROR_MESSAGE, ex.getMessage()));
    }

    private ErrorResponse buildError(Integer statusCode, String userMessage, String developerMessage) {
        return new ErrorResponse(statusCode, developerMessage, userMessage);
    }
}
