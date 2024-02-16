package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Reposiroty.PersonalProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalProjectService {

    @Autowired
    private PersonalProjectRepo personalProjectRepo;
    public List<PersonalProjectDTO> getAll(String language) {
        List<PersonalProjectDTO> projectsDTO = personalProjectRepo.getAll().stream().map(personalProjects -> personalProjects.toDTO(language)).toList();;
        return projectsDTO;
    }
}
