package com.anon.mongo.data.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("last_names")
@Data
public class LastName {

    @Id
    private String id;
    private String lastName;

}
