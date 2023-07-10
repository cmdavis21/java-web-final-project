package com.example.java_web_final_project.service;

import com.example.java_web_final_project.model.ClothingItem;
import com.example.java_web_final_project.repository.ClothingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingService {
    //----dependency injection of ClothingRepo interface----//

    //1. create an instance of ClothingRepository
    private final ClothingRepository clothingRepository;

    //2. create service constructor to make instance
    public ClothingService(ClothingRepository repository){
        clothingRepository = repository;
    }

    //3. CRUD applications

        //GET method
        public List<ClothingItem> findAll() {
            return clothingRepository.findAll();
        }

        //POST method
        public void save(ClothingItem item) {
            clothingRepository.save(item);
        }

        //PUT method
//        public void put(Long id, String fieldToUpdate, Object value) {
//            Optional<ClothingItem> optionalItem = clothingRepository.findById(id);
//            if (optionalItem.isPresent()) {
//                ClothingItem foundItem = optionalItem.get();
//                switch (fieldToUpdate) {
//                    case "imageURL" -> foundItem.setImageURL((String) value);
//                    case "itemType" -> foundItem.setItemType((String) value);
//                    case "sizes" ->
//                        ArrayList<String> newSizes = new ArrayList<>();
//                        newSizes.add((String) value);
//                        foundItem.setSizes(newSizes);
//                        break;
//                    case "colors" -> foundItem.setColors((String) value);
//                    case "category" -> foundItem.setCategory((String) value);
//                    case "description" -> foundItem.setDescription((String) value);
//                    case "price" -> foundItem.setPrice((Double) value);
//                    case "hasDiscount" -> foundItem.setHasDiscount((Boolean) value);
//                    default -> throw new IllegalArgumentException("Invalid field name: " + fieldToUpdate);
//                }
//                clothingRepository.save(foundItem);
//            }
//        }

        //DELETE method
        public void delete(Long id) {
            clothingRepository.deleteById(id);
        }
}
