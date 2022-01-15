package com.done.RegistrationService.appointment.handlers;

import com.done.RegistrationService.controller.routes.appointment.handlers.GetAppointmentsHandler;
import com.done.RegistrationService.db.AppointmentDb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetAppointmentsHandlerTests {
    @Mock private AppointmentDb appointmentDb;
    @InjectMocks private GetAppointmentsHandler getAppointmentsHandler;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void reset() {
        Mockito.reset(
                appointmentDb
        );
    }

    @Test
    public void testShouldGetAppointmentsWithoutCursorToken() {
        int limit = 30;
        String cursorToken = "";

        getAppointmentsHandler.handle(
                cursorToken,
                limit
        );

        verify(appointmentDb).fetchMultipleWithFilterAndSort(
                any(),
                any(),
                eq(limit)
        );
    }

    @Test
    public void testShouldGetAppointmentsWithCursorToken() {
        int limit = 30;
        String cursorToken = "100000_a1";

        getAppointmentsHandler.handle(
                cursorToken,
                limit
        );

        verify(appointmentDb).fetchMultipleWithFilterAndSort(
                any(),
                any(),
                eq(limit)
        );
    }
}
