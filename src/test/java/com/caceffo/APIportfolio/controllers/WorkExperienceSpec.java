package com.caceffo.APIportfolio.controllers;

import com.caceffo.APIportfolio.Bootstrap.WorkExperienceBoostrap;
import com.caceffo.APIportfolio.Domain.WorkExperience;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Repository.WorkExperienceRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("A work experience controller")
public class WorkExperienceSpec {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WorkExperienceRepo workRepo;
    @Autowired
    private WorkExperienceBoostrap workBoostrap;
    private final WorkExperience simpleWorkExp = new WorkExperience(
            new Langs("Desarrollador web", "Web developer"),
            new Langs("dsafdsfa", "dsadfds"),
            LocalDate.of(2023, 07, 01),
            LocalDate.of(2024, 02, 01)
    );
    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public void setUp() {
        mapper.registerModule(new JavaTimeModule());
    }

    @BeforeEach
    public void init() {
        workRepo.clear();
        workRepo.addElement(simpleWorkExp);
    }

    @AfterAll
    public void end() {
        workBoostrap.afterPropertiesSet();
    }

    @Test
    public void get_all_worksExp_then_works_fine() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/work/all")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.content().json(mapper.writeValueAsString(List.of(simpleWorkExp.toDTO("en")))))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void add_a_workExp_then_works_fine() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/work/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(simpleWorkExp))
                )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete_a_exist_workExp_works_fine() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/work/1/remove")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void delete_a_non_exist_workExp_works_wrong() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/work/2/remove")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
