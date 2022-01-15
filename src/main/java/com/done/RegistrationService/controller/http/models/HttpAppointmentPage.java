package com.done.RegistrationService.controller.http.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class HttpAppointmentPage {
    private final List<HttpAppointment> appointments;
    private final String nextCursorToken;

    @JsonCreator
    private HttpAppointmentPage(
            List<HttpAppointment> appointments,
            String nextCursorToken
    ) {
        this.appointments = appointments;
        this.nextCursorToken = nextCursorToken;
    }

    public static HttpAppointmentPage getDefaultInstance() {
        return HttpAppointmentPage.Builder
                .newInstance()
                .setAppointments(Collections.emptyList())
                .setNextCursorToken("")
                .build();
    }

    @JsonProperty("list")
    public List<HttpAppointment> getAppointments() {
        return appointments;
    }

    @JsonProperty("cursorToken")
    public String getNextCursorToken() {
        return nextCursorToken;
    }

    public static class Builder {
        private List<HttpAppointment> appointments;
        private String nextCursorToken;

        private Builder() {

        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setAppointments(List<HttpAppointment> appointments) {
            this.appointments = appointments;
            return this;
        }

        public Builder setNextCursorToken(String nextCursorToken) {
            this.nextCursorToken = isBlank(nextCursorToken) ? null : nextCursorToken;
            return this;
        }

        public HttpAppointmentPage build() {
            return new HttpAppointmentPage(appointments, nextCursorToken);
        }
    }
}
