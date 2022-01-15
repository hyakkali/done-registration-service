package com.done.RegistrationService.controller.http.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class HttpAppointment {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final long dateOfBirth;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final String licensePhotoUrl;
    private final long appointmentTime;

    @JsonCreator
    private HttpAppointment(
            String id,
            String firstName,
            String lastName,
            long dateOfBirth,
            String email,
            String phoneNumber,
            String address,
            String licensePhotoUrl,
            long appointmentTime
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.licensePhotoUrl = licensePhotoUrl;
        this.appointmentTime = appointmentTime;
    }

    public static HttpAppointment getDefaultInstance() {
        return HttpAppointment.Builder
                .newInstance()
                .setFirstName("")
                .setLastName("")
                .setDateOfBirth(0)
                .setEmail("")
                .setPhoneNumber("")
                .setAddress("")
                .setLicensePhotoUrl("")
                .setAppointmentTime(0)
                .build();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getLicensePhotoUrl() {
        return licensePhotoUrl;
    }

    public long getAppointmentTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return "HttpAppointment{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", licensePhotoUrl='" + licensePhotoUrl + '\'' +
                ", appointmentTime=" + appointmentTime +
                '}';
    }

    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private long dateOfBirth;
        private String email;
        private String phoneNumber;
        private String address;
        private String licensePhotoUrl;
        private long appointmentTime;

        private Builder() {
        }

        public static Builder newInstance() {
            return new Builder();
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setDateOfBirth(long dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setLicensePhotoUrl(String licensePhotoUrl) {
            this.licensePhotoUrl = licensePhotoUrl;
            return this;
        }

        public Builder setAppointmentTime(long appointmentTime) {
            this.appointmentTime = appointmentTime;
            return this;
        }

        public HttpAppointment build() {
            return new HttpAppointment(id, firstName, lastName, dateOfBirth, email, phoneNumber, address, licensePhotoUrl, appointmentTime);
        }
    }
}
