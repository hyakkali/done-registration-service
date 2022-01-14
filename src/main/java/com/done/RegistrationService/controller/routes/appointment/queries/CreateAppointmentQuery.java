package com.done.RegistrationService.controller.routes.appointment.queries;

import com.done.RegistrationService.controller.http.HttpBuilders;
import com.done.RegistrationService.controller.http.models.HttpAppointment;
import com.done.RegistrationService.controller.http.requests.CreateAppointmentRequest;
import com.done.RegistrationService.controller.routes.appointment.handlers.CreateAppointmentHandler;
import com.done.RegistrationService.model.pojos.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class CreateAppointmentQuery {
    @Autowired CreateAppointmentHandler createAppointmentHandler;

    public HttpAppointment handle(
            CreateAppointmentRequest request
    ) {
        Appointment newAppointment = createAppointmentHandler.handle(
                request.getFirstName(),
                request.getLastName(),
                Instant.ofEpochMilli(request.getDateOfBirth()),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAddress(),
                request.getLicensePhotoUrl(),
                Instant.ofEpochMilli(request.getAppointmentTime())
        );
        return HttpBuilders.buildAppointment(newAppointment);
    }
}
