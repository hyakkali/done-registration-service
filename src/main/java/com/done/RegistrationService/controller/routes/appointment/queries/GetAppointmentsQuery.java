package com.done.RegistrationService.controller.routes.appointment.queries;

import com.done.RegistrationService.controller.http.models.HttpAppointmentPage;
import com.done.RegistrationService.controller.routes.appointment.handlers.GetAppointmentsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAppointmentsQuery {
    @Autowired GetAppointmentsHandler getAppointmentsHandler;

    public HttpAppointmentPage handle(
            String cursorToken,
            int limit
    ) {
        return getAppointmentsHandler.handle(
                cursorToken,
                limit
        );
    }
}
