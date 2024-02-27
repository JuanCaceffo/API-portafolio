package com.caceffo.APIportfolio.Domain.helpers;

import com.caceffo.APIportfolio.Errors.BusinessException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String to;
    private String from;
    private String subject;
    private String content;

    public Email(){}
    public Email(String from, String to, String subject, String content){
        this.to = to.emptyIfIsNull();
        this.from = from.emptyIfIsNull();
        this.subject = subject.emptyIfIsNull();
        this.content = content.emptyIfIsNull();
    }
}
