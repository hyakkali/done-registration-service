package com.done.RegistrationService.db.mongo.collections;

import com.done.RegistrationService.model.pojos.MongoObject;
import com.mongodb.client.MongoCollection;

public abstract class BaseCollection<T extends MongoObject> {
    public abstract MongoCollection<T> getMongoCollection();

    protected void createIndices() {
    }
}
