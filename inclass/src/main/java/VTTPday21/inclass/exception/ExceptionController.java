package VTTPday21.inclass.exception;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import VTTPday21.inclass.model.exception.ApiError;
import VTTPday21.inclass.model.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiError> handleDataAccessException(Exception ex, HttpServletRequest request, HttpServletResponse response){
        ApiError apiError = new ApiError(1000, "Record not found :(", new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArguementException(IllegalArgumentException ex, HttpServletRequest request, HttpServletResponse response){
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //create your own ResourceNotFoundException class
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request, HttpServletResponse response){
        ApiError apiError = new ApiError(response.getStatus(), ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
