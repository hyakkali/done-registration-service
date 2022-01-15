package com.done.RegistrationService.controller.http.requests;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CreateAppointmentRequest {
    private String firstName;
    private String lastName;
    private long dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String licensePhotoUrl;
    private long appointmentTime;

    public CreateAppointmentRequest() {
    }

    @JsonCreator
    private CreateAppointmentRequest(
            String firstName,
            String lastName,
            long dateOfBirth,
            String email,
            String phoneNumber,
            String address,
            String licensePhotoUrl,
            long appointmentTime
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.licensePhotoUrl = licensePhotoUrl;
        this.appointmentTime = appointmentTime;
    }

    public static CreateAppointmentRequest getDefaultInstance() {
        return CreateAppointmentRequest.Builder
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicensePhotoUrl() {
        return licensePhotoUrl;
    }

    public void setLicensePhotoUrl(String licensePhotoUrl) {
        this.licensePhotoUrl = licensePhotoUrl;
    }

    public long getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(long appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "CreateAppointmentRequest{" +
                "firstName='" + firstName + '\'' +
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

        public CreateAppointmentRequest build() {
            return new CreateAppointmentRequest(firstName, lastName, dateOfBirth, email, phoneNumber, address, licensePhotoUrl, appointmentTime);
        }
    }
}
