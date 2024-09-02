package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;

public class DuplicatedProductException extends RuntimeException {

    public DuplicatedProductException(String message) {
        super(message);
    }
}


