package com.done.RegistrationService.model.pojos;

import java.time.Instant;

public class Appointment extends MongoObject {
    public static final String EMAIL_FIELD_NAME = "email";
    public static final String APPOINTMENT_TIME_FIELD_NAME = "appointmentTime";

    private String firstName;
    private String lastName;
    private Instant dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String licensePhotoUrl;
    private Instant appointmentTime;

    public Appointment() {
    }

    public Appointment(
            String id,
            String firstName,
            String lastName,
            Instant dateOfBirth,
            String email,
            String phoneNumber,
            String address,
            String licensePhotoUrl,
            Instant appointmentTime
    ) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.licensePhotoUrl = licensePhotoUrl;
        this.appointmentTime = appointmentTime;
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

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
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

    public Instant getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Instant appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", licensePhotoUrl='" + licensePhotoUrl + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                "} " + super.toString();
    }
}
