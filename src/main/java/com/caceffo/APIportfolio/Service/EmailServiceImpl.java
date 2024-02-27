package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.Domain.helpers.Email;
import com.caceffo.APIportfolio.Domain.helpers.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailServiceImpl implements MailSender {

    @Autowired
    private JavaMailSender emailSender;
    private final String from = "caceffojuan@gmail.com";

    @Override
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getContent());
        emailSender.send(message);
    }
}
