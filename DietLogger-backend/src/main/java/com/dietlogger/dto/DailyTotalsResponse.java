package com.dietlogger.dto;

public class DailyTotalsResponse {

    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public DailyTotalsResponse(int calories, int protein, int carbs, int fats) {
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFats() {
        return fats;
    }
}
