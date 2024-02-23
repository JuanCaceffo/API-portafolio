package com.caceffo.APIportfolio.Errors;

import com.caceffo.APIportfolio.DTOs.MessageDTO;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<MessageDTO> handleBusinessException(BusinessException ex, Locale locale){
        String message = messageSource.getMessage(ex.getMessage(),ex.params,locale);
        return new ResponseEntity<>(new MessageDTO(message) ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDTO> handleExceptions(Exception ex, Locale locale) {
        String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        ex.printStackTrace();
        return new ResponseEntity<>(new MessageDTO(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
