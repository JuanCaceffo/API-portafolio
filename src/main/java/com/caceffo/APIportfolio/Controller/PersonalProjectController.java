package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Service.PersonalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("projects")
public class PersonalProjectController {

    @Autowired
    private PersonalProjectService personalProjectService;

    //We can access to the locale because we have a config local resolver to set a default locale
    //TODO: Add swagger documentation
    //TODO: add tests for this endpoint
    @GetMapping("/all")
    public List<PersonalProjectDTO> getAllProjects(Locale locale){
        return personalProjectService.getAll(locale.language);
    }
}


