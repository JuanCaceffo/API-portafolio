package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.DTOs.WorkExperienceDTO;
import com.caceffo.APIportfolio.Domain.WorkExperience;
import com.caceffo.APIportfolio.Repository.WorkExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceService  {

    @Autowired
    private WorkExperienceRepo workRepo;

    public List<WorkExperienceDTO> getAll(String language) {
        return workRepo.getAll().stream().map(workExperience -> (workExperience.toDTO(language))).toList();
    }

    public void addWork(WorkExperience workExp) {
        workRepo.addElement(workExp);
    }
}
