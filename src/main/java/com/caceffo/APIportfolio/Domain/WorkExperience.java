package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.DTOs.WorkExperienceDTO;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class WorkExperience extends RepositoryProps {
    public Langs title;
    public Langs description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate finishDate;

    public WorkExperience(){}
    public WorkExperience(Langs title, Langs description, LocalDate startDate, LocalDate finishDate){
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = Optional.ofNullable(finishDate).orElse(LocalDate.now());
        this.validateDates();
    }

    public int totalMonths() {
        return Period.between(startDate,finishDate).getMonths();
    }

    public WorkExperienceDTO toDTO(String lang){
        return new WorkExperienceDTO(title.getFieldFromString(lang),description.getFieldFromString(lang),startDate,finishDate,totalMonths());
    }
    /* ---------------------------- validations ----------------------------*/

    public void validateDates(){
       if (this.startDate.isAfter(this.finishDate)){
           throw new BusinessException("Exception.WorckExperiencie.invalidStartDate");
       }
    }
}
