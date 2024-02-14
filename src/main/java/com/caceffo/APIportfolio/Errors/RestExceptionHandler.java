package com.caceffo.APIportfolio.Errors;

import com.caceffo.APIportfolio.DTOs.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class RestExceptionHandler {
    private static final String UNEXPECTED_ERROR = "Exception.unexpected";
    private final MessageSource messageSource;

    @Autowired
    public RestExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<MessageDTO> handleBussinesException(BusinessException ex, Locale locale){
        String message = messageSource.getMessage(ex.getMessage(),null,locale);
        return new ResponseEntity<>(new MessageDTO(message) ,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDTO> handleExceptions(Exception ex, Locale locale) {
        String errorMessage = messageSource.getMessage(UNEXPECTED_ERROR, null, locale);
        ex.printStackTrace();
        return new ResponseEntity<>(new MessageDTO(errorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestMessage> handleArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getAllErrors()
                .stream()
                .map(objectError -> messageSource.getMessage(objectError, locale))
                .collect(Collectors.toList());
        return new ResponseEntity<>(new RestMessage(errorMessages), HttpStatus.BAD_REQUEST);
    }*/
}
