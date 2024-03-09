package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.DTOs.WorkExperienceDTO;
import com.caceffo.APIportfolio.Domain.WorkExperience;
import com.caceffo.APIportfolio.Service.WorkExperienceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = {"http://192.168.100.4:4200/", "http://localhost:4200/", "http://192.168.1.52:4200/", "https://portafolio-18j9.onrender.com"})
@RestController
@RequestMapping("work")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workService;

    @Operation(summary = "Get all work experiences")
    @GetMapping("/all")
    public List<WorkExperienceDTO> getAll(Locale locale){
        return workService.getAll(locale.language);
    }

    @Operation(summary = "add a worck experience")
    @PostMapping("/add")
    public void add(@RequestBody WorkExperience workExp){
        workService.addWork(workExp);
    }
    @Operation(summary = "delete a work experience")
    @DeleteMapping("/{id}/remove")
    public void delete(@PathVariable Integer id){
        workService.delete(id);
    }
}
