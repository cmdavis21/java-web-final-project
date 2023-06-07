package com.example.java_web_final_project.controller;

import com.example.java_web_final_project.model.ClothingItem;
import com.example.java_web_final_project.service.ClothingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/inventory")
public class InventoryController {

    //----dependency injection----//

    //1. create and instance of the ClothingService object
    private final ClothingService clothingService;

    //2. create a constructor
    public InventoryController(ClothingService routeServer) {
        clothingService = routeServer;
    }

    //3. controller methods to route the CRUD requests
    @GetMapping
    public List<ClothingItem> findAll() {
        return clothingService.findAll();
    }

    @PostMapping("/new")
    public void saveItems(@RequestBody List<ClothingItem> items) {
        for (ClothingItem item : items) {
            clothingService.save(item);
        }
    }

    @PutMapping("/update")
    public void putItem(@RequestBody ClothingItem item) { clothingService.put(item); }

    @DeleteMapping("/remove/{id}")
    public void deleteItem(@PathVariable Long id) { clothingService.delete(id); }
}
