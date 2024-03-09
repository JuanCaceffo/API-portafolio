package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Service.PersonalProjectService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = {"http://192.168.100.4:4200/", "http://localhost:4200/", "http://192.168.1.52:4200/", "https://portafolio-18j9.onrender.com"})
@RestController
@RequestMapping("project")
public class PersonalProjectController {

    @Autowired
    private PersonalProjectService personalProjectService;

    //We can access to the locale wihtout hederRequest because we have a config local resolver to set a default locale
    @Operation(summary = "Get all personal projects")
    @GetMapping("/all")
    public List<PersonalProjectDTO> getAllProjects(Locale locale){
        return personalProjectService.getAll(locale.language);
    }

    @Operation(summary = "Delete a personal project")
    @DeleteMapping("/{id}/delete")
    public void deleteProject(@PathVariable Integer id){
        personalProjectService.delete(id);
    }

    @Operation(summary = "Create a personal project")
    @PostMapping("/create")
    public void createAProject(@RequestBody PersonalProjects data){
        personalProjectService.create(data);
    }
}


