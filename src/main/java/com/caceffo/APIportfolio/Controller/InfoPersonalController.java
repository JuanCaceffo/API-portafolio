package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Service.InfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoPersonalController {
    @Autowired
    private InfoService infoService;

    @Operation(summary = "get all technical skills")
    @GetMapping("/skills")
    public List<Skills> skills(){
        return infoService.getAll();
    }

    @Operation(summary = "remove skill")
    @DeleteMapping("/skill/{id}/remove")
    public void deleteSkill(@PathVariable Integer id){
        infoService.removeSkill(id);
    }
    @Operation(summary = "add skill")
    @PostMapping("/add/skill")
    public void addSkill(@RequestBody Skills skill){
        infoService.addSkill(skill);
    }

}
