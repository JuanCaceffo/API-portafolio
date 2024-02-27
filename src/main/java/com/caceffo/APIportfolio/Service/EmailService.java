package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.DTOs.ContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;

@Controller
public class EmailService{

    @Autowired
    private JavaMailSender emailSender;
    private final String from = "caceffojuan@gmail.com";
    private final String subject = "CONTACTO PORTAFOLIO - ";

    public void sendEmail(ContactDTO data) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(from);
        message.setSubject(subject + data.getName());
        message.setText(String.format("Email: %s\nMensaje:\n%s",data.getEmail(),data.getMessage()));
        emailSender.send(message);
    }
}
