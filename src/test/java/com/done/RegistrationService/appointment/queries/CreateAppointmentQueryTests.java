package com.done.RegistrationService.appointment.queries;

import com.done.RegistrationService.appointment.TestPOJOFactory;
import com.done.RegistrationService.controller.http.requests.CreateAppointmentRequest;
import com.done.RegistrationService.controller.routes.appointment.handlers.CreateAppointmentHandler;
import com.done.RegistrationService.controller.routes.appointment.queries.CreateAppointmentQuery;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CreateAppointmentQueryTests {
    @Mock CreateAppointmentHandler createAppointmentHandler;
    @InjectMocks CreateAppointmentQuery createAppointmentQuery;

    @BeforeAll
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void reset() {
        Mockito.reset(
                createAppointmentHandler
        );
    }

    @Test
    public void testShouldCreateAppointment() {
        String firstName = "first name";
        String lastName = "last name";
        long dateOfBirth = 10000;
        String email = "email";
        String phoneNumber = "phone number";
        String address = "address";
        String licensePhotoUrl = "license url";
        long appointmentTime = 1000000;
        CreateAppointmentRequest request = CreateAppointmentRequest.Builder
                .newInstance()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDateOfBirth(dateOfBirth)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setLicensePhotoUrl(licensePhotoUrl)
                .setAppointmentTime(appointmentTime)
                .build();

        when(createAppointmentHandler.handle(
                anyString(),
                anyString(),
                any(),
                anyString(),
                anyString(),
                anyString(),
                anyString(),
                any()
        )).thenReturn(TestPOJOFactory.genTestAppointment());

        createAppointmentQuery.handle(request);

        verify(createAppointmentHandler).handle(
                firstName,
                lastName,
                Instant.ofEpochMilli(dateOfBirth),
                email,
                phoneNumber,
                address,
                licensePhotoUrl,
                Instant.ofEpochMilli(appointmentTime)
        );
    }
}
