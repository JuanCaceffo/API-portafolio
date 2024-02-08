package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Errors.BussinesExeption;
import org.joda.time.Months;
import org.joda.time.LocalDate;
import java.util.Optional;

public class WorkExperiencie {
    public String title;
    public String description;
    public LocalDate startDate;
    public LocalDate finishDate;

    public WorkExperiencie(String title, String description, LocalDate startDate, LocalDate finishDate){
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = Optional.ofNullable(finishDate).orElse(LocalDate.now());
        this.validateDates();
    }

    public int totalMonths() {
        return Months.monthsBetween(this.startDate, this.finishDate).getMonths();
    }

    /* ---------------------------- validations ----------------------------*/

    private void validateDates(){
       if (this.startDate.isAfter(this.finishDate)){
           //TODO: Change the exception when the API will internationalized
           throw new BussinesExeption("ingrese una fecha de inicio de actividad menor o igual que la de fin");
       }
    }
}
