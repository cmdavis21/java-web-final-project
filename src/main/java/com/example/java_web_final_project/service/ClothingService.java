package com.example.java_web_final_project.service;

import com.example.java_web_final_project.model.ClothingItem;
import com.example.java_web_final_project.repository.ClothingRepository;
import org.springframework.stereotype.Service;

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

        //get method
        public List<ClothingItem> findAll() {
            return clothingRepository.findAll();
        }

        //post method
        public void save(ClothingItem item) {
            clothingRepository.save(item);
        }

        //put method
        public void put(ClothingItem item) {
            Long id = item.getId();
            Optional<ClothingItem> optionalItem = clothingRepository.findById(id);
            if (optionalItem.isPresent()) {
                ClothingItem foundItem = optionalItem.get();
                foundItem.setItemType(item.getItemType());
                foundItem.setDescription(item.getDescription());
                clothingRepository.save(foundItem);
            }
        }

        //delete method
        public void delete(Long id) {
            clothingRepository.deleteById(id);
        }
}
