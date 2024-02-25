package com.caceffo.APIportfolio.Bootstrap;

import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Domain.WorkExperience;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Repository.WorkExperienceRepo;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkExperienceBoostrap implements InitializingBean {
    @Autowired
    private WorkExperienceRepo workRepo;

    ArrayList<WorkExperience> workExpList = new ArrayList(
            List.of(
                    new WorkExperience(
                            new Langs("Desarrollador web", "Web developer"),
                            new Langs("dsafdsfa", "dsadfds"),
                            new LocalDate(2023,07,01),
                            new LocalDate(2024,02,01)
                    )
            )
    );

    @Override
    public void afterPropertiesSet() {
        workExpList.forEach(workExperience -> workRepo.addElement(workExperience));
    }
}
