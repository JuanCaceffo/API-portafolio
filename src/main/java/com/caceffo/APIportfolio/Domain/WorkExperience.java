package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.DTOs.WorkExperienceDTO;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;
import org.joda.time.Months;
import org.joda.time.LocalDate;

import java.util.Locale;
import java.util.Optional;

public class WorkExperience extends RepositoryProps {
    public Langs title;
    public Langs description;
    public LocalDate startDate;
    public LocalDate finishDate;

    public WorkExperience(Langs title, Langs description, LocalDate startDate, LocalDate finishDate){
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = Optional.ofNullable(finishDate).orElse(LocalDate.now());
        this.validateDates();
    }

    public int totalMonths() {
        return Months.monthsBetween(this.startDate, this.finishDate).getMonths();
    }

    public WorkExperienceDTO toDTO(String lang){
        return new WorkExperienceDTO(title.getFieldFromString(lang),description.getFieldFromString(lang),startDate,finishDate,totalMonths());
    }
    /* ---------------------------- validations ----------------------------*/

    private void validateDates(){
       if (this.startDate.isAfter(this.finishDate)){
           throw new BusinessException("Exception.WorckExperiencie.invalidStartDate");
       }
    }
}
