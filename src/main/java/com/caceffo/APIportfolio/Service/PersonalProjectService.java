package com.caceffo.APIportfolio.Service;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Repository.PersonalProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalProjectService {

    @Autowired
    private PersonalProjectRepo personalProjectRepo;
    public List<PersonalProjectDTO> getAll(String language) {
        List<PersonalProjectDTO> projectsDTO = personalProjectRepo.getAll().stream().map(personalProjects -> personalProjects.toDTO(language)).toList();;
        return projectsDTO;
    }

    public void create(PersonalProjects data) {
        data.validateFields();
        personalProjectRepo.addElement(data);
    }

    public void delete(Integer id) {
        PersonalProjects project = personalProjectRepo.getElementById(id);
        personalProjectRepo.deleteElement(project);
    }
}
