package com.example.java_web_final_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

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
    private String image; //references image associated id to the image sql table that stores only product images

    @Column(name = "item")
    private String itemType; //i.e., jacket, shirt, pants, etc.

    @Column(name = "sizes")
    private ArrayList<String> sizes; // sizes available

    @Column(name = "colors")
    private ArrayList<String> colors; //colors available

    @Column(name = "category")
    private String category; //men or women's fashion?

    @Column(name = "description")
    private String description; //facts about the item

    @Column(name = "price")
    private Double price; // Price of the item

    @Column(name = "discount")
    private boolean hasDiscount; //is there a discount available?

}
