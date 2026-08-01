package com.dietlogger.dto;

import com.dietlogger.model.FoodItem;

public class FoodItemResponse {

    private Long id;
    private String name;
    private Integer calories;
    private Integer protein;
    private Integer carbs;
    private Integer fats;

    public FoodItemResponse(FoodItem item) {
        this.id = item.getId();
        this.name = item.getName();
        this.calories = item.getCalories();
        this.protein = item.getProtein();
        this.carbs = item.getCarbs();
        this.fats = item.getFats();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public Integer getCarbs() {
        return carbs;
    }

    public Integer getFats() {
        return fats;
    }
}
