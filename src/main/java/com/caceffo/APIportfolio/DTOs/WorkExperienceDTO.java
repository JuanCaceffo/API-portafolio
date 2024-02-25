package com.caceffo.APIportfolio.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.LocalDate;


@AllArgsConstructor
@Getter
public class WorkExperienceDTO {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate finishDate;
    private Integer totalMonths;
}
