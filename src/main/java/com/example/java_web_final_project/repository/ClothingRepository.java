package com.example.java_web_final_project.repository;

import com.example.java_web_final_project.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends JpaRepository<ClothingItem, Long> {
    //custom methods

//    public void findByItem(ClothingItem item) {
//        return item.findByItem(item);
//    }
}
