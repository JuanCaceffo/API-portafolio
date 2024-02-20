package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Service.PersonalProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("project")
public class PersonalProjectController {

    @Autowired
    private PersonalProjectService personalProjectService;

    //We can access to the locale because we have a config local resolver to set a default locale
    @Operation(summary = "Get all personal projects")
    @GetMapping("/all")
    public List<PersonalProjectDTO> getAllProjects(Locale locale){
        return personalProjectService.getAll(locale.language);
    }

    @Operation(summary = "Create a personal project")
    @PostMapping("/create")
    public void createAProject(@RequestBody PersonalProjects data){
        System.out.println(data);
        personalProjectService.create(data);
    }
}


