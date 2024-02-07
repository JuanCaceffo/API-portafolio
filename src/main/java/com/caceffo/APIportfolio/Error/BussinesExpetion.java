package com.caceffo.APIportfolio.Error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BussinesExpetion extends RuntimeException{
    public BussinesExpetion(String msg){
        super(msg);
    }
}
