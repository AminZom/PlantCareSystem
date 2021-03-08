package com.jsip.plant;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("plants")
public class PlantController
{
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping(value = "/all")
    public List<Plant> getPlants() {
        return plantService.getPlants();
    }

    @PostMapping(value = "/add")
    public void addNewPlants(@RequestBody String plantsJSON) {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode plantObjs = mapper.readTree(plantsJSON);
            ArrayList<Plant> plants = new ArrayList<Plant>();
            for(JsonNode plantObj : plantObjs) {
                Plant newPlant = new Plant(plantObj.get("Name").textValue(),
                                           plantObj.get("Last Watered Date").textValue(),
                                           plantObj.get("Watering frequency").textValue());
                plants.add(newPlant);
            }
            plantService.addNewPlants(plants);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
