package com.caceffo.APIportfolio.Domain.helpers;

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
        this.from.isBlankException("You neeed to specify where from the email");
        this.to.isBlankException("You neeed to specify where's go the email");
        this.subject.isBlankException("The subjet can't be empty");
    }
}
