package com.caceffo.APIportfolio.controllers;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Repository.PersonalProjectRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Locale;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("A personal project controller")
public class PersonalProjectControllerSpec {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PersonalProjectRepo personalProjectRepo;
    private final ObjectMapper mapper = new ObjectMapper();
    private final PersonalProjects personalProject = new PersonalProjects(
            new Langs("Aplicacion web", "App web"),
            new Langs("WorldCapp 2023", "WorldCapp 2023"),
            new Langs("worldcapp-2023 es una app de album de figuritas desrrollada con el framework Angular 16 y typescrip. Realizada con muy buenas practicas utilizando el patron de diseño arquitecutral MVC permitiendo una gran escalabilidad del proyecto", "worldcapp-2023 is a sticker album app developed with the Angular 16 framework and TypeScript. It has been implemented with excellent practices using the MVC architectural design pattern, allowing for great scalability of the project."),
            "https://github.com/JuanCaceffo/worldcapp-2023",
            "https://worldcapp-2023.onrender.com/"
    );

    @BeforeEach
    public void init() {
        personalProjectRepo.clear();
        personalProjectRepo.addElement(personalProject);
    }

    @Test
    public void when_you_call_a_get_method_with_all_language_responses_to_return_all_projects_works_fine() throws Exception {
        performAndGetLanguageResponse("en", List.of(personalProject.toDTO("en")));
        performAndGetLanguageResponse("es", List.of(personalProject.toDTO("es")));
    }

    private void performAndGetLanguageResponse(String language, List<PersonalProjectDTO> expectedResponse) throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/projects/all")
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("Accept-Language", language)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedResponse)));
    }

}
