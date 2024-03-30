package com.anon.mongo.data.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user_names")
@Data
public class UserName {
    @Id
    private String id;
    private String userName;

}
