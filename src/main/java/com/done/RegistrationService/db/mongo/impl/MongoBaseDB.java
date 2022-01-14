package com.done.RegistrationService.db.mongo.impl;

import com.done.RegistrationService.db.BaseDB;
import com.done.RegistrationService.db.mongo.collections.BaseCollection;
import com.done.RegistrationService.model.pojos.MongoObject;
import com.done.RegistrationService.utils.LoggerUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoBaseDB<T extends MongoObject> implements BaseDB<T> {
    private static final int DEFAULT_BATCH_SIZE = 50;

    private final MongoCollection<T> mongoCollection;

    public MongoBaseDB(BaseCollection<T> collection) {
        this.mongoCollection = collection.getMongoCollection();
        LoggerUtil.logInfo(
                getClass(),
                "successfully initialized"
        );
    }

    @Override
    public List<T> fetchMultipleWithFilterAndSort(
            Bson filter,
            Bson sort,
            int limit
    ) {
        LoggerUtil.logInfo(
                getClass(),
                "fetching multiple with filter: " + filter
                        + " sort: " + sort
                        + " limit: " + limit
        );
        return iterableToList(
                collection()
                        .find(filter)
                        .sort(sort)
                        .limit(limit)
        );
    }

    @Override
    public void createOne(T object) {
        LoggerUtil.logInfo(getClass(), "creating one: " + object);
        collection().insertOne(object);
    }

    protected MongoCollection<T> collection() {
        return mongoCollection;
    }

    protected List<T> iterableToList(MongoIterable<T> mongoIterable) {
        List<T> list = new ArrayList<>();
        MongoCursor<T> mongoCursor = mongoIterable
                .batchSize(DEFAULT_BATCH_SIZE)
                .cursor();
        while (mongoCursor.hasNext()) {
            list.add(mongoCursor.next());
        }
        mongoIterable.cursor().close();
        return list;
    }
}
