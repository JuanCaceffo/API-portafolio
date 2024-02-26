package com.caceffo.APIportfolio.controllers;

import com.caceffo.APIportfolio.Bootstrap.InfoPersonalBoostrap;
import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Repository.SkillsRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("A info personal controller")
public class InfoPersonalControllerSpec {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private InfoPersonalBoostrap infoBoostrap;
    @Autowired
    private SkillsRepo skillsRepo;
    private final ObjectMapper mapper = new ObjectMapper();
    private final Skills skill = new Skills("dsadsadsaf");

    @BeforeEach
    public void init(){
        skillsRepo.clear();
        skillsRepo.addElement(skill);
    }
    @AfterAll
    public void end(){
        infoBoostrap.afterPropertiesSet();
    }

    @Test
    public void get_all_skills_works_fine() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/info/skills")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of(skill))));
    }

    @Test
    public void delete_a_exist_skill_works_fine() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/info/skill/1/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void delete_a_non_exist_skill_works_wrong() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/info/skill/2/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void when_create_a_good_skill_then_works_fine() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/info/add/skill")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(skill))
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
