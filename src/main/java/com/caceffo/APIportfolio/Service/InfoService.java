package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Repository.SkillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    @Autowired
    private SkillsRepo skillsRepo;

    public List<Skills> getAll() {
        return skillsRepo.getAll();
    }

    public void removeSkill(Integer id) {
        Skills skill = skillsRepo.getElementById(id);
        skillsRepo.deleteElement(skill);
    }

    public void addSkill(Skills skill) {
        skillsRepo.addElement(skill);
    }
}
