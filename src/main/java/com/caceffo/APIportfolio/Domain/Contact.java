package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Domain.helpers.Email;
import com.caceffo.APIportfolio.Domain.helpers.MailSender;

public class Contact {
    private String email = "caceffojuan@gmail.com";

    public void sendEmail(MailSender mailSender, Email email){
        email.from = this.email;
        mailSender.sendEmail(email);
    }
}