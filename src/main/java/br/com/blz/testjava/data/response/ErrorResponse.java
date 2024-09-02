package br.com.blz.testjava.data.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private final Integer httpStatusCode;
    private final String developerMessage;
    private final String userMessage;

    public ErrorResponse(Integer httpStatusCode, String developerMessage, String userMessage) {
        this.httpStatusCode = httpStatusCode;
        this.developerMessage = developerMessage;
        this.userMessage = userMessage;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }
}
