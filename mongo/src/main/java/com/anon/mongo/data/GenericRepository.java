package com.anon.mongo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GenericRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Object> findAll(String collectionName) {
        return mongoTemplate.findAll(Object.class, collectionName);
    }

    public Object findById(String id, String collectionName) {
        return mongoTemplate.findById(id, Object.class, collectionName);
    }

    public <T> T save(T entity, String collectionName) {
        mongoTemplate.save(entity, collectionName);
        return entity;
    }

    public <T> T update(String id, T entity, String collectionName) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.save(entity, collectionName);
        return entity;
    }

    public void delete(String id, String collectionName) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, collectionName);
    }
}
