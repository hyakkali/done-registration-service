package com.done.RegistrationService.model.pojos;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Objects that have their own collection should extend this class.
 */

public abstract class MongoObject {
    public static final String ID_FIELD_NAME = "_id";
    public static final String CREATED_AT_FIELD_NAME = "createdAt";
    public static final String UPDATED_AT_FIELD_NAME = "updatedAt";

    private String id;
    private Instant createdAt;
    private Instant updatedAt;

    public MongoObject() {
    }

    public MongoObject(String id) {
        this(
                id,
                Instant.now(),
                Instant.now()
        );
    }

    public MongoObject(
            String id,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static <T extends MongoObject> List<String> extractIds(List<T> objects) {
        return objects
                .stream()
                .map(MongoObject::getId)
                .collect(Collectors.toList());
    }

    public static <T extends MongoObject> Set<String> extractIdsAsSet(List<T> objects) {
        return objects
                .stream()
                .map(MongoObject::getId)
                .collect(Collectors.toSet());
    }

    public static <T extends MongoObject> List<T> sortByDateCreatedDescending(List<T> objects) {
        return objects
                .stream()
                .sorted((object1, object2) -> Long.compare(
                        object2.getCreatedAt().toEpochMilli(),
                        object1.getCreatedAt().toEpochMilli()
                ))
                .collect(Collectors.toList());
    }

    public static <T extends MongoObject> Map<String, T> buildIdToObjectMap(Collection<T> objects) {
        return objects
                .stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                MongoObject::getId,
                                Function.identity()
                        )
                );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoObject that = (MongoObject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MongoObject{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
