package com.dietlogger.repository;

import com.dietlogger.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findByUserIdOrderByNameAsc(Long userId);
    Optional<FoodItem> findByIdAndUserId(Long id, Long userId);
}
