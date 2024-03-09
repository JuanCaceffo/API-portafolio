package com.caceffo.APIportfolio.controllers;

import com.caceffo.APIportfolio.Bootstrap.PersonalProjectsBootstrap;
import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Repository.PersonalProjectRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("A personal project controller")
public class PersonalProjectControllerSpec {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PersonalProjectRepo personalProjectRepo;
    @Autowired
    private PersonalProjectsBootstrap projectsBootstrap;

    private final ObjectMapper mapper = new ObjectMapper();
    private final PersonalProjects personalProject = new PersonalProjects(
            new Langs("Aplicacion web", "App web"),
            new Langs("WorldCapp 2023", "WorldCapp 2023"),
            new Langs("worldcapp-2023 es una app de album de figuritas desrrollada con el framework Angular 16 y typescrip. Realizada con muy buenas practicas utilizando el patron de diseño arquitecutral MVC permitiendo una gran escalabilidad del proyecto", "worldcapp-2023 is a sticker album app developed with the Angular 16 framework and TypeScript. It has been implemented with excellent practices using the MVC architectural design pattern, allowing for great scalability of the project."),
            "https://github.com/JuanCaceffo/worldcapp-2023",
            "https://worldcapp-2023.onrender.com/",
            new ArrayList<>()
    );

    @BeforeEach
    public void init() {
        personalProjectRepo.clear();
        personalProjectRepo.addElement(personalProject);
    }

    @AfterEach
    public void end() throws Exception {
        projectsBootstrap.afterPropertiesSet();
    }
    @Test
    public void when_you_call_a_get_method_with_all_language_responses_to_return_all_projects_works_fine() throws Exception {
        performAndGetLanguageResponse("en", List.of(personalProject.toDTO("en")));
        performAndGetLanguageResponse("es", List.of(personalProject.toDTO("es")));
    }

    @Test
    public void when_call_the_post_method_to_creat_a_project_works_fine() throws Exception {
        final PersonalProjects goodProject = new PersonalProjects(new Langs("dsadsa","dsad"),new Langs("dsadsa","dsad"),new Langs("dsadsa","dsad"),"","",null);
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/project/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(goodProject))
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void when_call_the_post_method_to_creat_a_project_then_works_wrong() throws Exception {
        final PersonalProjects badProject = new PersonalProjects(new Langs("dsadsa","dsad"),new Langs("dsadsa","dsad"),new Langs("dsadsa","dsad"),"","",null);
        badProject.setType(null);
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/project/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(badProject))
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

     @Test
     public void when_delete_a_personal_projects_then_works_fine() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/project/1/delete")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
     }
    @Test
    public void when_delete_a_personal_projects_that_non_exist_then_make_exception() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/project/2/delete")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

    private void performAndGetLanguageResponse(String language, List<PersonalProjectDTO> expectedResponse) throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/project/all")
                                .contentType(MediaType.APPLICATION_JSON)
                                .header("Accept-Language", language)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(expectedResponse)));
    }

}
