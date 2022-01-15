package com.done.RegistrationService.appointment.queries;

import com.done.RegistrationService.controller.http.models.HttpAppointmentPage;
import com.done.RegistrationService.controller.routes.appointment.handlers.GetAppointmentsHandler;
import com.done.RegistrationService.controller.routes.appointment.queries.GetAppointmentsQuery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetAppointmentQueryTests {
    @Mock GetAppointmentsHandler getAppointmentsHandler;
    @InjectMocks GetAppointmentsQuery getAppointmentsQuery;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void reset() {
        Mockito.reset(
                getAppointmentsHandler
        );
    }

    @Test
    public void testShouldGetAppointments() {
        String cursorToken = "cursorToken";
        int limit = 30;

        when(getAppointmentsHandler.handle(
                anyString(),
                anyInt()
        )).thenReturn(HttpAppointmentPage.getDefaultInstance());

        getAppointmentsQuery.handle(
                cursorToken,
                limit
        );

        verify(getAppointmentsHandler).handle(
                cursorToken,
                limit
        );
    }
}
