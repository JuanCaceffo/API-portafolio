package com.caceffo.APIportfolio.Domain.helpers;

import com.caceffo.APIportfolio.Errors.BusinessException;
import lombok.Getter;

@Getter
public class Email {
    private String to;
    private String subject;
    private String content;

    public Email(String to, String subject, String content){
        this.to = to.emptyIfIsNull();
        this.subject = subject.emptyIfIsNull();
        this.content = content.emptyIfIsNull();
        //validations
        this.to.isBlankException(new BusinessException("Exception.Email.whereGoes"));
        this.subject.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Subject"));
    }
}
