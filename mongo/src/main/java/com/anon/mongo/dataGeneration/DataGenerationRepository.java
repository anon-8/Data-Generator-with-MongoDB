package com.anon.mongo.dataGeneration;

import com.mongodb.BasicDBObject;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.Random;

@Repository
public class DataGenerationRepository {

    private final MongoOperations mongoOperations;
    private final Random random;

    public DataGenerationRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
        this.random = new Random();
    }
    public BasicDBObject findRandom(String collectionName) {
        long count = mongoOperations.count(new Query(), collectionName);
        int randomIndex = random.nextInt((int) count);
        Query query = new Query().limit(1).skip(randomIndex);
        return mongoOperations.findOne(query, BasicDBObject.class, collectionName);
    }
}
