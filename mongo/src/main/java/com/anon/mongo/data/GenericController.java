package com.anon.mongo.data;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GenericController {

    private final GenericRepository genericRepository;

    public GenericController(GenericRepository genericRepository) {
        this.genericRepository = genericRepository;
    }

    @PostMapping("/populate/{entityName}")
    public String populateCollection(@PathVariable String entityName, @RequestBody List<Object> entities) {
        entities.forEach(entity -> genericRepository.save(entity, entityName));
        return "Collection " + entityName + " populated successfully.";
    }

    @GetMapping("/entities/{entityName}")
    public List<Object> getAllEntities(@PathVariable String entityName) {
        return genericRepository.findAll(entityName);
    }

    @PostMapping("/entities/{entityName}")
    public Object createEntity(@PathVariable String entityName, @RequestBody Object entity) {
        return genericRepository.save(entity, entityName);
    }

    @GetMapping("/entities/{entityName}/{id}")
    public Object getEntityById(@PathVariable String entityName, @PathVariable String id) {
        return genericRepository.findById(id, entityName);
    }

    @PutMapping("/entities/{entityName}/{id}")
    public Object updateEntity(@PathVariable String entityName, @PathVariable String id, @RequestBody Object entity) {
        return genericRepository.update(id, entity, entityName);
    }

    @DeleteMapping("/entities/{entityName}/{id}")
    public String deleteEntity(@PathVariable String entityName, @PathVariable String id) {
        genericRepository.delete(id, entityName);
        return "Entity with ID " + id + " deleted successfully.";
    }
}

