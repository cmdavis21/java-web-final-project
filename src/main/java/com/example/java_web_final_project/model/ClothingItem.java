package com.example.java_web_final_project.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "inventory")
public class ClothingItem {
    //instance fields
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "item")
    private String itemType; //i.e., jacket, shirt, pants, etc.

    @Column(name = "description")
    private String description; //facts about the item

    //constructors
    public ClothingItem() {
        //empty JPA constructor
    }

    public ClothingItem(Long id, String itemType, String description) {
        this.id = id;
        this.itemType = itemType;
        this.description = description;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //equals, hashCode and toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClothingItem that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getItemType(), that.getItemType()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemType(), getDescription());
    }

    @Override
    public String toString() {
        return "ClothingItem{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
