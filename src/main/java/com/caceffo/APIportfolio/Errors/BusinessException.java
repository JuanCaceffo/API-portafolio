package com.caceffo.APIportfolio.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BusinessException extends RuntimeException{
    public BusinessException(String msg){
        super(msg);
    }
}
