package com.done.RegistrationService.controller.routes.appointment.handlers;

import com.done.RegistrationService.controller.http.HttpBuilders;
import com.done.RegistrationService.controller.http.models.HttpAppointmentPage;
import com.done.RegistrationService.db.AppointmentDb;
import com.done.RegistrationService.model.pojos.Appointment;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
public class GetAppointmentsHandler {
    @Autowired private AppointmentDb appointmentDb;

    public HttpAppointmentPage handle(
            String cursorToken,
            int limit
    ) {
        Bson filter = createCursorTokenFilter(cursorToken);
        Bson sort = createSort();
        List<Appointment> appointments = appointmentDb.fetchMultipleWithFilterAndSort(
                filter,
                sort,
                limit
        );
        String nextCursorToken = createCursorToken(
                appointments,
                limit
        );
        return HttpBuilders.buildAppointmentPage(
                appointments,
                nextCursorToken
        );
    }

    private static Bson createSort() {
        return Sorts.orderBy(
                Sorts.descending(Appointment.APPOINTMENT_TIME_FIELD_NAME),
                Sorts.ascending(Appointment.ID_FIELD_NAME)
        );
    }

    private static Bson createCursorTokenFilter(String cursorToken) {
        if (isBlank(cursorToken)) {
            return new Document();
        }
        String[] tokens = cursorToken.split("_");
        Instant createdAt = Instant.ofEpochMilli(Long.parseLong(tokens[0]));
        String id = tokens[1];
        return Filters.or(
                Filters.lt(
                        Appointment.APPOINTMENT_TIME_FIELD_NAME,
                        createdAt
                ),
                Filters.and(
                        Filters.eq(
                                Appointment.APPOINTMENT_TIME_FIELD_NAME,
                                createdAt
                        ),
                        Filters.gt(
                                Appointment.ID_FIELD_NAME,
                                id
                        )
                )
        );
    }

    private static String createCursorToken(
            List<Appointment> appointments,
            int limit
    ) {
        if (appointments.isEmpty() || appointments.size() < limit) {
            return "";
        }
        Appointment lastAppointment = appointments.get(appointments.size() - 1);
        return lastAppointment.getCreatedAt().toEpochMilli() + "_" + lastAppointment.getId();
    }
}
