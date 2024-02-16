package com.caceffo.APIportfolio.DTOs;

import com.caceffo.APIportfolio.Domain.helpers.Langs;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class PersonalProjectDTO {
    private String type;
    private String title;
    private String description;
    private String repo;
    private String deploy;
}
