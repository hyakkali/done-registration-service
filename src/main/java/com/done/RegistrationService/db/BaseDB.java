package com.done.RegistrationService.db;

import com.done.RegistrationService.model.pojos.MongoObject;
import org.bson.conversions.Bson;

import java.util.List;

public interface BaseDB<T extends MongoObject> {
    /**
     * Fetches multiple objects with a filter and sort
     *
     * @param filter Filter to find objects
     * @param sort   Criteria to sort objects by
     * @param limit  Maximum number of objects to return
     * @return List of objects
     */
    List<T> fetchMultipleWithFilterAndSort(
            Bson filter,
            Bson sort,
            int limit
    );

    /**
     * Creates an object
     *
     * @param object Object to create
     */
    void createOne(T object);
}
