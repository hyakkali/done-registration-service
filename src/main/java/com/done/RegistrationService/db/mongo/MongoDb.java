package com.done.RegistrationService.db.mongo;

import com.done.RegistrationService.db.mongo.collections.AppointmentCollection;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ReadConcern;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Component;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

@Component("mongoDb")
public class MongoDb {
    private static final String POJO_PACKAGE_LOCATION = "com.done.RegistrationService.model.pojos";
    private static final String DB_USERNAME_KEY = "DB_USERNAME";
    private static final String DB_PASSWORD_KEY = "DB_PASSWORD";
    private static final String DB_HOST_KEY = "DB_HOST";
    private static final String DB_NAME_KEY = "DB_NAME";

    private final MongoClient client;
    private final AppointmentCollection appointmentCollection;

    public MongoDb() {
        String dbName = System.getenv().get(DB_NAME_KEY);
        ConnectionString connectionString = genConnectionString();
        CodecRegistry pojoRegistry = fromProviders(
                PojoCodecProvider.builder()
                        .register(POJO_PACKAGE_LOCATION)
                        .automatic(true)
                        .build()
        );

        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                pojoRegistry
        );

        MongoClientSettings mongoClientSettings = MongoClientSettings
                .builder()
                .applyConnectionString(connectionString)
                .writeConcern(WriteConcern.MAJORITY)
                .readConcern(ReadConcern.LOCAL)
                .codecRegistry(pojoCodecRegistry)
                .build();

        client = MongoClients.create(mongoClientSettings);
        MongoDatabase mongoDatabase = client.getDatabase(dbName);
        appointmentCollection = new AppointmentCollection(mongoDatabase);
    }

    public AppointmentCollection getAppointmentCollection() {
        return appointmentCollection;
    }

    public void close() {
        client.close();
    }

    private ConnectionString genConnectionString() {
        String template = "mongodb+srv://%s:%s@%s/test?retryWrites=true&w=majority";
        String dbUsername = System.getenv().get(DB_USERNAME_KEY);
        String dbPassword = System.getenv().get(DB_PASSWORD_KEY);
        String dbHostName = System.getenv().get(DB_HOST_KEY);
        return new ConnectionString(String.format(template, dbUsername, dbPassword, dbHostName));
    }
}