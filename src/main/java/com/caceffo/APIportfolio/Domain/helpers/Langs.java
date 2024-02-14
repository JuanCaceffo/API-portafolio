package com.caceffo.APIportfolio.Domain.helpers;

import com.caceffo.APIportfolio.Errors.BusinessException;

import java.util.Optional;

public class Langs {
    private String es;
    private String en;
    public Langs(String es, String en){
        this.en = en.emptyIfIsNull();
        this.es = es.emptyIfIsNull();
        //validations
        this.fieldsBlankException();
    }
    public void fieldsBlankException(){
        if(es.isBlank() || en.isBlank()){
            throw new BusinessException("Exception.Lang.someLangIsEmpty");
        }
    }
}
