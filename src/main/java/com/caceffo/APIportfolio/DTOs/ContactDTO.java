package com.caceffo.APIportfolio.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContactDTO {
    private String message;
    private String email;
    private String name;
}
