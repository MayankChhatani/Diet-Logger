package com.dietlogger.service;

import com.dietlogger.dto.FoodItemRequest;
import com.dietlogger.dto.FoodItemResponse;
import com.dietlogger.exception.ApiException;
import com.dietlogger.model.FoodItem;
import com.dietlogger.model.User;
import com.dietlogger.repository.FoodItemRepository;
import com.dietlogger.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;
    private final UserRepository userRepository;

    public FoodItemService(FoodItemRepository foodItemRepository, UserRepository userRepository) {
        this.foodItemRepository = foodItemRepository;
        this.userRepository = userRepository;
    }

    public List<FoodItemResponse> getAllForUser(Long userId) {
        return foodItemRepository.findByUserIdOrderByNameAsc(userId).stream()
                .map(FoodItemResponse::new)
                .collect(Collectors.toList());
    }

    public FoodItemResponse addFoodItem(Long userId, FoodItemRequest request) {
        User user = userRepository.getReferenceById(userId);

        FoodItem item = new FoodItem();
        item.setUser(user);
        item.setName(request.getName());
        item.setCalories(request.getCalories());
        item.setProtein(request.getProtein());
        item.setCarbs(request.getCarbs());
        item.setFats(request.getFats());

        return new FoodItemResponse(foodItemRepository.save(item));
    }

    public void deleteFoodItem(Long userId, Long foodItemId) {
        FoodItem item = foodItemRepository.findByIdAndUserId(foodItemId, userId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Food item not found"));
        foodItemRepository.delete(item);
    }
}
