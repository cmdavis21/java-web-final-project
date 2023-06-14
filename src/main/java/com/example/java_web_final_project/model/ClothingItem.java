package com.example.java_web_final_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class ClothingItem {
    //instance fields
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String imageURL; //image url

    @Column(name = "item", nullable = false)
    private String itemType; //i.e., jacket, shirt, pants, etc.

    @Column(name = "sizes", nullable = false)
    private String sizes; //sizes available

    @Column(name = "category", nullable = false)
    private String category; //men or women's fashion?

    @Column(name = "description")
    private String description; //facts about the item

    @Column(name = "price", nullable = false)
    private double price; //price of item

    @Column(name = "discount")
    private boolean hasDiscount; //is there a discount available?

}
