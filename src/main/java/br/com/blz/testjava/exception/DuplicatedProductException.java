package br.com.blz.testjava.exception;

public class DuplicatedProductException extends RuntimeException {

    public DuplicatedProductException(String message) {
        super(message);
    }
}


