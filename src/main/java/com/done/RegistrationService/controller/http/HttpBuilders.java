package com.done.RegistrationService.controller.http;

import com.done.RegistrationService.App;
import com.done.RegistrationService.controller.http.models.HttpAppointment;
import com.done.RegistrationService.controller.http.models.HttpAppointmentPage;
import com.done.RegistrationService.model.pojos.Appointment;

import java.util.List;
import java.util.stream.Collectors;

public class HttpBuilders {
    public static HttpAppointment buildAppointment(
            Appointment appointment
    ) {
        return HttpAppointment.Builder
                .newInstance()
                .setId(appointment.getId())
                .setFirstName(appointment.getFirstName())
                .setLastName(appointment.getLastName())
                .setDateOfBirth(appointment.getDateOfBirth().toEpochMilli())
                .setEmail(appointment.getEmail())
                .setPhoneNumber(appointment.getPhoneNumber())
                .setAddress(appointment.getAddress())
                .setLicensePhotoUrl(appointment.getLicensePhotoUrl())
                .setAppointmentTime(appointment.getAppointmentTime().toEpochMilli())
                .build();
    }

    public static List<HttpAppointment> buildAppointments(
            List<Appointment> appointments
    ) {
        return appointments
                .stream()
                .map(HttpBuilders::buildAppointment)
                .collect(Collectors.toList());
    }

    public static HttpAppointmentPage buildAppointmentPage(
            List<Appointment> appointments,
            String nextCursorToken
    ) {
        return HttpAppointmentPage.Builder
                .newInstance()
                .setAppointments(buildAppointments(appointments))
                .setNextCursorToken(nextCursorToken)
                .build();
    }
}
