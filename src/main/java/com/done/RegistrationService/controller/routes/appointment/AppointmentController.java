package com.done.RegistrationService.controller.routes.appointment;

import com.done.RegistrationService.controller.http.models.HttpAppointment;
import com.done.RegistrationService.controller.http.models.HttpAppointmentPage;
import com.done.RegistrationService.controller.http.requests.CreateAppointmentRequest;
import com.done.RegistrationService.controller.routes.Controller;
import com.done.RegistrationService.controller.routes.appointment.queries.CreateAppointmentQuery;
import com.done.RegistrationService.controller.routes.appointment.queries.GetAppointmentsQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/appointment",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class AppointmentController extends Controller {
    @Autowired CreateAppointmentQuery createAppointmentQuery;
    @Autowired GetAppointmentsQuery getAppointmentsQuery;

    @PostMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HttpAppointment> createAppointment(
            @RequestBody CreateAppointmentRequest request
    ) {
        HttpAppointment newAppointment = createAppointmentQuery.handle(request);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping("")
    public HttpAppointmentPage getAppointments(
            @RequestParam(name = CURSOR_TOKEN_PARAM_KEY, defaultValue = "") String cursorToken,
            @RequestParam(name = LIMIT_PARAM_KEY, defaultValue = DEFAULT_LIMIT) int limit
    ) {
        return getAppointmentsQuery.handle(
                cursorToken,
                limit
        );
    }
}
