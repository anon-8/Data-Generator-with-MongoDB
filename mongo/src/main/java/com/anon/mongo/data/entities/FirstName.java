package com.anon.mongo.data.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("first_names")
@Data
public class FirstName {

    @Id
    private String id;
    private String name;
}
