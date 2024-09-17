package co.edu.unbosque.springdemo.model;

import org.springdoc.api.ErrorMessage;

public class BaseResponse {
    private int status;
    private String message;
    private ErrorMessage error;

    public BaseResponse(int status, String message, ErrorMessage error) {
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public BaseResponse(int status, ErrorMessage error) {
        this.status = status;
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }
}
