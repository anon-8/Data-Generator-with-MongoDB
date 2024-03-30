package com.anon.mongo.dataGeneration;

import org.springframework.stereotype.Component;
import com.mifmif.common.regex.Generex;
import com.mongodb.BasicDBObject;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
@Component
public class DataGenerationService {
    private final DataGenerationRepository dataGenerationRepository;

    public DataGenerationService(DataGenerationRepository dataGenerationRepository) {
        this.dataGenerationRepository = dataGenerationRepository;
    }
    public List<Record> generateRecords(DataGenerationRequest dataGenerationRequest) {

        List<Record> records = new ArrayList<>();

        int numberOfRecords = dataGenerationRequest.getNumberOfRecords();
        for (int i = 0; i < numberOfRecords; i++) {
            Record record = new Record();

            for ( Map.Entry<String, String> entry : dataGenerationRequest.getDataFromDB().entrySet() ) {
                record.addData(entry.getValue(), getRandomDocument(entry.getKey()));
            }

            for ( Map.Entry<String, String> entry : dataGenerationRequest.getDataFromRegex().entrySet() ) {
                record.addData(entry.getKey(), generateDataFromRegex(entry.getValue()));
            }

            records.add(record);
        }
        return records;
    }
    public String getRandomDocument(String collectionName) {

        BasicDBObject document = dataGenerationRepository.findRandom(collectionName);
        Object field = document.get(convertToCamelCase(collectionName));

        return field.toString();
    }
    public String generateDataFromRegex(String regex) {
        Generex generex = new Generex(regex);
        return generex.random();
    }
    public static String convertToCamelCase(String input) {

        if (input.endsWith("s")) {
            input = input.substring(0, input.length() - 1);
        }

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '_') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    result.append(Character.toLowerCase(currentChar));
                }
            }
        }

        return result.toString();
    }

}
