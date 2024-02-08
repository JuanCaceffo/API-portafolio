package com.caceffo.APIportfolio.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BussinesExeption extends RuntimeException{
    public BussinesExeption(String msg){
        super(msg);
    }
}
