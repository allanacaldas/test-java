package br.com.blz.testjava.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}


