package com.anon.mongo.dataGeneration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataGenerationController {


    private final DataGenerationService dataGenerationService;

    public DataGenerationController(DataGenerationService dataGenerationService) {
        this.dataGenerationService = dataGenerationService;
    }

    @GetMapping("/generateRecords")
    public List<Record> generateRecords(@RequestBody DataGenerationRequest dataGenerationRequest) {

        return dataGenerationService.generateRecords(dataGenerationRequest);
    }


}