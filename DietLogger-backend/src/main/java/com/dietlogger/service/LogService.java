package com.dietlogger.service;

import com.dietlogger.dto.DailyTotalsResponse;
import com.dietlogger.dto.HistoryEntryResponse;
import com.dietlogger.exception.ApiException;
import com.dietlogger.model.FoodItem;
import com.dietlogger.model.FoodLog;
import com.dietlogger.model.User;
import com.dietlogger.repository.FoodItemRepository;
import com.dietlogger.repository.FoodLogRepository;
import com.dietlogger.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LogService {

    private final FoodLogRepository foodLogRepository;
    private final FoodItemRepository foodItemRepository;
    private final UserRepository userRepository;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE; // yyyy-MM-dd

    public LogService(FoodLogRepository foodLogRepository,
                       FoodItemRepository foodItemRepository,
                       UserRepository userRepository) {
        this.foodLogRepository = foodLogRepository;
        this.foodItemRepository = foodItemRepository;
        this.userRepository = userRepository;
    }

    public DailyTotalsResponse logFood(Long userId, Long foodItemId) {
        FoodItem foodItem = foodItemRepository.findByIdAndUserId(foodItemId, userId)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Food item not found"));

        User user = userRepository.getReferenceById(userId);

        FoodLog log = new FoodLog();
        log.setUser(user);
        log.setFoodItem(foodItem);
        log.setLogDate(LocalDate.now());
        foodLogRepository.save(log);

        return getTodayTotals(userId);
    }

    public DailyTotalsResponse getTodayTotals(Long userId) {
        List<FoodLog> todaysLogs = foodLogRepository.findByUserIdAndLogDate(userId, LocalDate.now());
        return sumLogs(todaysLogs);
    }

    public List<HistoryEntryResponse> getHistory(Long userId) {
        List<FoodLog> allLogs = foodLogRepository.findAllByUserId(userId);

        // Group by date, preserving the descending order the query already returned
        Map<LocalDate, List<FoodLog>> byDate = allLogs.stream()
                .collect(Collectors.groupingBy(
                        FoodLog::getLogDate,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        return byDate.entrySet().stream()
                .map(entry -> {
                    DailyTotalsResponse totals = sumLogs(entry.getValue());
                    return new HistoryEntryResponse(
                            entry.getKey().format(DATE_FORMAT),
                            totals.getCalories(),
                            totals.getProtein(),
                            totals.getCarbs(),
                            totals.getFats()
                    );
                })
                .collect(Collectors.toList());
    }

    private DailyTotalsResponse sumLogs(List<FoodLog> logs) {
        int calories = 0, protein = 0, carbs = 0, fats = 0;

        for (FoodLog log : logs) {
            FoodItem item = log.getFoodItem();
            calories += item.getCalories();
            protein += item.getProtein();
            carbs += item.getCarbs();
            fats += item.getFats();
        }

        return new DailyTotalsResponse(calories, protein, carbs, fats);
    }
}
