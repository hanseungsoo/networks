package io.human.networks.controller.response;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {

    private String exception;
    private String message;
    private String path;
    private Date timestamp;
    private List<FieldError> errors;
}
