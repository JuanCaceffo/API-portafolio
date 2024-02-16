package com.caceffo.APIportfolio.Domain.helpers;

import com.caceffo.APIportfolio.Errors.BusinessException;

import java.util.Optional;

public class Langs {
    public String es;
    public String en;
    public Langs(String es, String en){
        this.en = en.emptyIfIsNull();
        this.es = es.emptyIfIsNull();
        //validations
        this.fieldsBlankException();
    }

    public String getFieldFromString(String field){
        try {
            return String.valueOf(this.getClass().getField(field).get(this));
        }catch (NoSuchFieldException | IllegalAccessException  e){
            throw new BusinessException("caca");
        }
    }
    public void fieldsBlankException(){
        if(es.isBlank() || en.isBlank()){
            throw new BusinessException("Exception.Lang.someLangIsEmpty");
        }
    }
}
