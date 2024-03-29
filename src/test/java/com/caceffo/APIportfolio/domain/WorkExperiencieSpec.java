package com.caceffo.APIportfolio.domain;

import com.caceffo.APIportfolio.Domain.WorkExperience;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Errors.BusinessException;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class WorkExperiencieSpec {

    private MockedStatic<LocalDate> localDateMockedStatic;

    @BeforeEach
    void setUp(){
        localDateMockedStatic = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS);
    }

    @AfterEach
    void tearDown(){
        localDateMockedStatic.reset();
        localDateMockedStatic.close();
    }

    @Test
    void the_total_months_of_a_worckExperienice_with_valid_start_and_finish_dates_worcks_fine() {
        WorkExperience experiencie = new WorkExperience(new Langs("lala","lala"), new Langs("lala","lala"), LocalDate.of(2024, 01, 01), LocalDate.of(2024, 02, 01));
        assertEquals(experiencie.totalMonths(), 1);
    }

    @Test
    void worckExperiencie_without_finishDate_is_remplazed_with_actual_date(){
        LocalDate currentDate = LocalDate.of(2024,02,02);
        localDateMockedStatic.when(LocalDate::now).thenReturn(currentDate);
        WorkExperience experiencie = new WorkExperience(new Langs("lala","lala"), new Langs("lala","lala"), LocalDate.of(2024, 01, 01),null);
        //Assert
        assertEquals(experiencie.finishDate,currentDate);
    }

    @Test
    void workExp_without_field_works_wrong(){
        Exception exception = assertThrows(BusinessException.class, () -> {
            new WorkExperience(null, new Langs("lala","lala"), LocalDate.of(2023, 03, 01), LocalDate.of(2024, 02, 01));
        });
        assertTrue(exception.getMessage().contains("Exception.Langs.CantBeEmpty"));
    }

    @Test
    void startDate_of_the_worckExperiencie_is_greater_than_the_finshDate(){
        //Arragne
        Exception exception = assertThrows(BusinessException.class, () -> {
            new WorkExperience(new Langs("lala","lala"), new Langs("lala","lala"), LocalDate.of(2024, 03, 01), LocalDate.of(2024, 02, 01));
        });
        //Assert
        assertTrue(exception.getMessage().contains("Exception.WorckExperiencie.invalidStartDate"));
    }

}
