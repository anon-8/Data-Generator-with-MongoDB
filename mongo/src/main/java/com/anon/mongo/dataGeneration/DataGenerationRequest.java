package com.anon.mongo.dataGeneration;
import lombok.Data;

import java.util.Map;

@Data
public class DataGenerationRequest {

    private String recordName;
    private Map<String, String> dataFromDB;
    private Map<String, String> dataFromRegex;
    private Integer numberOfRecords;
}
