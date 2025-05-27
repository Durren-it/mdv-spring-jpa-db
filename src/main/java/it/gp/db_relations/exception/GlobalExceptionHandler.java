package it.gp.db_relations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> badRequest(BadRequestException brex, WebRequest request) {
        return new ResponseEntity<>(brex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> constraintViolation(ConstraintViolationException cvex, WebRequest request) {
        return new ResponseEntity<>("Constraint Violation: " + cvex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> dataAccess(DataAccessException daex, WebRequest request) {
        return new ResponseEntity<>("Database Error: " + daex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<String> httpMessageNotReadable(HttpMessageNotReadableException hmnrex, WebRequest request) {
        return new ResponseEntity<>("HTTP Message Not Readable: " + hmnrex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> illegalArgument(IllegalArgumentException iaex, WebRequest request) {
        return new ResponseEntity<>("Illegal Argument Exception: " + iaex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> methodArgumentNotValid(MethodArgumentNotValidException manvex, WebRequest request) {
        return new ResponseEntity<>("Method Argument Not Valid: " + manvex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> nullPointer(NullPointerException npex, WebRequest request) {
        return new ResponseEntity<>("Null Pointer Exception: " + npex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> resourceNotFound(ResourceNotFoundException rnfex, WebRequest request) {
        return new ResponseEntity<>(rnfex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<String> uncaughtException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
