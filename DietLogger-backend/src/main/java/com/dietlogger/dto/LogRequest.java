package com.dietlogger.dto;

import jakarta.validation.constraints.NotNull;

public class LogRequest {

    @NotNull(message = "foodItemId is required")
    private Long foodItemId;

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }
}
