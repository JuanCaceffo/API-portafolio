package com.caceffo.APIportfolio.domain;

import com.caceffo.APIportfolio.Domain.Skills;
import com.caceffo.APIportfolio.Errors.BussinesExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SkillsSpec {
    @Test
    void The_skill_is_created_fine() {
        Skills skill = new Skills("url");
        assertEquals(skill.imgUrl, "url");
    }

    void When_create_a_skill_without_url_works_wrong() {
        Exception exception =  assertThrows(BussinesExeption.class,() -> {
            new Skills(null);
        });
        assertTrue(exception.getMessage().contains("The images url can not be empty"));
    }
}