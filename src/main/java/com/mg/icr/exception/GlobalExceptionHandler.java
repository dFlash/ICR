package com.mg.icr.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicationException.class)
    public @ResponseBody ExceptionInfo handleApplicationException(ApplicationException e) {
        String msg = e.getMessage();
        LOGGER.error(msg);
        return buildResponse(msg);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody ExceptionInfo handleApplicationException(Exception e) {
        LOGGER.error(e.getMessage());
        return buildResponse("Internal server error occurred");
    }

    private ExceptionInfo buildResponse(String message) {
        ExceptionInfo response = new ExceptionInfo();
        response.setMessage(message);
        return response;
    }
}
