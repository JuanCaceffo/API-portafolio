package com.caceffo.APIportfolio.domain;

import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Errors.BussinesExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalProjectsSpec {


    private void throw_an_bussines_expetion(Exception exception, String msg) {
        //Assert
        assertTrue(exception.getMessage().contains(msg));
    }

    @Test
    public void PersonalProject_cant_have_an_empty_type() {
        throw_an_bussines_expetion(assertThrows(BussinesExeption.class, () -> {
            new PersonalProjects(null, "dsada", "dadsa", null, null);
        }), "Type cannot be blank");
    }

    @Test
    public void PersonalProject_cant_have_an_empty_title() {
        throw_an_bussines_expetion(assertThrows(BussinesExeption.class, () -> {
            new PersonalProjects("dada", null, "dadsa", null, null);
        }), "Title cannot be blank");
    }

    @Test
    public void PersonalProject_cant_have_an_empty_description() {
        throw_an_bussines_expetion(assertThrows(BussinesExeption.class, () -> {
            new PersonalProjects("dada", "dadsa", null, null, null);
        }), "Description cannot be blank");
    }
}
