package VTTPday21.workshop.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import VTTPday21.workshop.model.exception.ApiError;
import VTTPday21.workshop.model.exception.IDNotFoundException;
import VTTPday21.workshop.model.exception.OrderNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionControlller {
    
    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<ApiError> handleIdNotFoundException(IDNotFoundException ex, HttpServletRequest request, HttpServletResponse resp){

        ApiError apiError = new ApiError(404, ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    };

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiError> handleOrderNotFoundException(OrderNotFoundException ex, HttpServletRequest request, HttpServletResponse resp){

        ApiError apiError = new ApiError(404, ex.getMessage(), new Date()); //message input in repository

        return new ResponseEntity<ApiError>(apiError, HttpStatus.NOT_FOUND);
    };



}



