package com.done.RegistrationService.db.mongo.impl;

import com.done.RegistrationService.db.AppointmentDb;
import com.done.RegistrationService.db.mongo.MongoDb;
import com.done.RegistrationService.model.pojos.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("appointmentDb")
public class MongoAppointmentDb extends MongoBaseDB<Appointment> implements AppointmentDb {

    @Autowired
    public MongoAppointmentDb(MongoDb mongoDb) {
        super(mongoDb.getAppointmentCollection());
    }
}
