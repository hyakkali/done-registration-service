package com.done.RegistrationService.db.mongo.collections;

import com.done.RegistrationService.model.pojos.Appointment;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;

public class AppointmentCollection extends BaseCollection<Appointment> {
    private static final String COLLECTION_NAME = "appointment";

    private final MongoCollection<Appointment> mongoCollection;

    public AppointmentCollection(MongoDatabase mongoDatabase) {
        this.mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME, Appointment.class);
        this.createIndices();
    }

    @Override
    public void createIndices() {
        mongoCollection.createIndex(
                Indexes.ascending(
                        Appointment.EMAIL_FIELD_NAME,
                        Appointment.APPOINTMENT_TIME_FIELD_NAME
                ),
                new IndexOptions().unique(true)
        );
    }

    @Override
    public MongoCollection<Appointment> getMongoCollection() {
        return mongoCollection;
    }
}
