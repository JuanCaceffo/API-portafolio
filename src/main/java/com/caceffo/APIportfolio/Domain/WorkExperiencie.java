package com.caceffo.APIportfolio.Domain;

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
    }

    public int totalMonths() {
        return Months.monthsBetween(this.startDate, this.finishDate).getMonths();
    }

}
