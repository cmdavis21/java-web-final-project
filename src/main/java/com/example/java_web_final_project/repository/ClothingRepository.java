package com.example.java_web_final_project.repository;

import com.example.java_web_final_project.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends JpaRepository<ClothingItem, Long> {
    //custom repository search methods

    //find items by name

    //find items by category, men or women's fashion

    //find items by size

    //find items by price

    //find items by discount
}
