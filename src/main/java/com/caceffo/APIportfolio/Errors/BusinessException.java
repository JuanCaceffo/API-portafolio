package com.caceffo.APIportfolio.Errors;

public class BusinessException extends RuntimeException{
    Object[] params;
    public BusinessException(String msg){
        super(msg);
    }
    public BusinessException(Object... params){
        this.params = params;
    }

}
