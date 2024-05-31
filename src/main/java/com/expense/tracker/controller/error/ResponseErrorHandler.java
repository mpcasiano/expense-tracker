package com.expense.tracker.controller.error;

import com.expense.tracker.exception.BadRequestException;
import com.expense.tracker.exception.ResourceNotFoundException;
import com.expense.tracker.exception.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ServerException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("000");
        errorResponse.setMessage("INTERNAL_SERVER_ERROR");
        errorResponse.setDetails(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(BadRequestException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("001");
        errorResponse.setMessage("BAD_REQUEST");
        errorResponse.setDetails(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode("002");
        errorResponse.setMessage("RESOURCE_NOT_FOUND");
        errorResponse.setDetails(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
