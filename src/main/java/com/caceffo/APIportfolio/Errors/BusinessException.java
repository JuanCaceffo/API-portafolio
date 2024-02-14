package com.caceffo.APIportfolio.Errors;

public class BusinessException extends RuntimeException{
    Object[] params;
    public BusinessException(String msg, Object... params){
        super(msg);
        this.params = params;
    }

}
