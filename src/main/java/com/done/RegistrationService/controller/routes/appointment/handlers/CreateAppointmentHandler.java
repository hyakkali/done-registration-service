package com.done.RegistrationService.controller.routes.appointment.handlers;

import com.done.RegistrationService.db.AppointmentDb;
import com.done.RegistrationService.exception.DBOperationUnsuccessfulException;
import com.done.RegistrationService.model.pojos.Appointment;
import com.done.RegistrationService.model.pojos.POJOFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CreateAppointmentHandler {
    @Autowired private AppointmentDb appointmentDb;

    public Appointment handle(
            String firstName,
            String lastName,
            Instant dateOfBirth,
            String email,
            String phoneNumber,
            String address,
            String licensePhotoUrl,
            Instant appointmentTime
    ) {
        Appointment newAppointment = POJOFactory.genAppointment(
                firstName,
                lastName,
                dateOfBirth,
                email,
                phoneNumber,
                address,
                licensePhotoUrl,
                appointmentTime
        );
        try {
            appointmentDb.createOne(newAppointment);
        } catch (Exception exception) {
            throw new DBOperationUnsuccessfulException();
        }
        return newAppointment;
    }
}
