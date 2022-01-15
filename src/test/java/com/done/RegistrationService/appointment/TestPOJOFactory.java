package com.done.RegistrationService.appointment;

import com.done.RegistrationService.model.pojos.Appointment;
import com.done.RegistrationService.model.pojos.POJOFactory;

import java.time.Instant;

public class TestPOJOFactory {
    public static Appointment genTestAppointment() {
        return POJOFactory.genAppointment(
                "first name",
                "last name",
                Instant.EPOCH,
                "email",
                "phone number",
                "address",
                "license url",
                Instant.EPOCH
        );
    }
}
