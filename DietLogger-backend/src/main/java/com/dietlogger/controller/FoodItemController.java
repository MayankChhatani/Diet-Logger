package com.dietlogger.controller;

import com.dietlogger.config.CustomUserDetails;
import com.dietlogger.dto.FoodItemRequest;
import com.dietlogger.dto.FoodItemResponse;
import com.dietlogger.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin
public class FoodItemController {

    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping
    public ResponseEntity<List<FoodItemResponse>> getAll(@AuthenticationPrincipal CustomUserDetails user) {
        return ResponseEntity.ok(foodItemService.getAllForUser(user.getId()));
    }

    @PostMapping
    public ResponseEntity<FoodItemResponse> add(
            @AuthenticationPrincipal CustomUserDetails user,
            @Valid @RequestBody FoodItemRequest request) {
        FoodItemResponse created = foodItemService.addFoodItem(user.getId(), request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @AuthenticationPrincipal CustomUserDetails user,
            @PathVariable Long id) {
        foodItemService.deleteFoodItem(user.getId(), id);
        return ResponseEntity.noContent().build();
    }
}
