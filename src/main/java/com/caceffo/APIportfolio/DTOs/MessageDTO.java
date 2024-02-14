package com.caceffo.APIportfolio.DTOs;

import lombok.Getter;
import java.util.List;

@Getter
public class MessageDTO {
    private String message;
    private List<String> messages;

    public MessageDTO(List<String> messages) {
        this.messages = messages;
    }

    public MessageDTO(String message) {
        this.message = message;
    }
}