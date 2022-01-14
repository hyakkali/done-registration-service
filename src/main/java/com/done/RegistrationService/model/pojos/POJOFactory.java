package com.done.RegistrationService.model.pojos;

import org.bson.types.ObjectId;

import java.time.Instant;

public class POJOFactory {
    public static Appointment genAppointment(
            String firstName,
            String lastName,
            Instant dateOfBirth,
            String email,
            String phoneNumber,
            String address,
            String licensePhotoUrl,
            Instant appointmentTime
    ) {
        return new Appointment(
                genUniqueId(),
                firstName,
                lastName,
                dateOfBirth,
                email,
                phoneNumber,
                address,
                licensePhotoUrl,
                appointmentTime
        );
    }

    public static String genUniqueId() {
        return ObjectId.get().toString();
    }
}
