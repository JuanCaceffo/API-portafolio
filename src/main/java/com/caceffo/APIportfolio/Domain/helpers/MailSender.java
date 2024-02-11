package com.caceffo.APIportfolio.Domain.helpers;

public interface MailSender {
    default void sendEmail(Email email){}
}
