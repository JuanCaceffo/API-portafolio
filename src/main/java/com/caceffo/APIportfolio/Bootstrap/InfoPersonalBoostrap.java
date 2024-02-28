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
            new Skills("/assets/mocks-imgs/skills/react.png"),
            new Skills("/assets/mocks-imgs/skills/angular.png"),
            new Skills("/assets/mocks-imgs/skills/ts.png"),
            new Skills("/assets/mocks-imgs/skills/java.png"),
            new Skills("/assets/mocks-imgs/skills/js.png"),
            new Skills("/assets/mocks-imgs/skills/springboot.png"),
            new Skills("/assets/mocks-imgs/skills/sass.png"),
            new Skills("/assets/mocks-imgs/skills/html.png"),
            new Skills("/assets/mocks-imgs/skills/git.png"),
            new Skills("/assets/mocks-imgs/skills/kotlin.png")
    ));

    @Override
    public void afterPropertiesSet() {
        skillsList.forEach(skill -> skillsRepo.addElement(skill));
    }
}
