package com.anon.mongo.dataGeneration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Record {

    private Map<String, String> additionalProperties = new HashMap<>();
    
    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String key, String value) {
        additionalProperties.put(key, value);
    }
    public void addData(String key, String value) {
        additionalProperties.put(key, value);
    }
}
