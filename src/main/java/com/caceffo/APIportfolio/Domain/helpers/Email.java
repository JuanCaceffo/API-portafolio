package com.caceffo.APIportfolio.Domain.helpers;

import com.caceffo.APIportfolio.Errors.BusinessException;

public class Email {
    public String from;
    private String to;
    private String subject;
    private String content;

    public Email(String from, String to, String subject, String content){
        this.from = from.emptyIfIsNull();
        this.to = to.emptyIfIsNull();
        this.subject = subject.emptyIfIsNull();
        this.content = content.emptyIfIsNull();
        //validations
        this.from.isBlankException(new BusinessException("Exception.Email.whereFrom"));
        this.to.isBlankException(new BusinessException("Exception.Email.whereGoes"));
        this.subject.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Subject"));
    }
}
