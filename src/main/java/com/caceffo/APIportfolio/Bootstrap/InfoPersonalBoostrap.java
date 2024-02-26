package com.caceffo.APIportfolio.Bootstrap;

import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Repository.SkillsRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InfoPersonalBoostrap implements InitializingBean {

    @Autowired
    private SkillsRepo skillsRepo;

    List<Skills> skillsList = new ArrayList(List.of(
            new Skills("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRl9dpnFbblscfaol5rV0rZ9g5DR_dr3_DV4QWsXFiVLA&s")
    ));

    @Override
    public void afterPropertiesSet() {
        skillsList.forEach(skill -> skillsRepo.addElement(skill));
    }
}
