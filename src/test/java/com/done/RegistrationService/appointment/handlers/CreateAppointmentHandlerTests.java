package com.done.RegistrationService.appointment.handlers;

import com.done.RegistrationService.controller.routes.appointment.handlers.CreateAppointmentHandler;
import com.done.RegistrationService.db.AppointmentDb;
import com.done.RegistrationService.exception.DBOperationUnsuccessfulException;
import com.mongodb.MongoCommandException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateAppointmentHandlerTests {
    @Mock private AppointmentDb appointmentDb;
    @InjectMocks private CreateAppointmentHandler createAppointmentHandler;

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
    public void testAppointmentShouldBeCreatedInDb() {
        createAppointmentHandler.handle(
                "first name",
                "last name",
                Instant.EPOCH,
                "email",
                "phone number",
                "address",
                "license url",
                Instant.EPOCH
        );

        verify(appointmentDb).createOne(any());
    }

    @Test
    public void testShouldThrowExceptionIfAppointmentNotCreated() {
        doThrow(MongoCommandException.class).when(appointmentDb).createOne(any());

        assertThrows(DBOperationUnsuccessfulException.class, () -> createAppointmentHandler.handle(
                "first name",
                "last name",
                Instant.EPOCH,
                "email",
                "phone number",
                "address",
                "license url",
                Instant.EPOCH
        ));
    }
}
