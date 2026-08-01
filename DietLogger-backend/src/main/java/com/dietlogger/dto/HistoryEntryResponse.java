package com.dietlogger.dto;

public class HistoryEntryResponse {

    private String date;
    private int calories;
    private int protein;
    private int carbs;
    private int fats;

    public HistoryEntryResponse(String date, int calories, int protein, int carbs, int fats) {
        this.date = date;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public String getDate() {
        return date;
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
