package io.human.networks.controller;

import io.human.networks.controller.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

@Slf4j
@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handle(HttpServletRequest request, DataIntegrityViolationException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setException(ex.getClass().getName());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(request.getServletPath());
        errorResponse.setTimestamp(new Date());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
