package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Service.InfoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoPersonalController {
    @Autowired
    private InfoService infoService;

    @Operation(summary = "get all thecnical skills")
    @GetMapping("/skills")
    public List<Skills> skills(){
        return infoService.getAll();
    }
}
