package com.dietlogger.repository;

import com.dietlogger.model.FoodLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FoodLogRepository extends JpaRepository<FoodLog, Long> {

    @Query("SELECT fl FROM FoodLog fl JOIN FETCH fl.foodItem " +
           "WHERE fl.user.id = :userId AND fl.logDate = :date")
    List<FoodLog> findByUserIdAndLogDate(@Param("userId") Long userId, @Param("date") LocalDate date);

    @Query("SELECT fl FROM FoodLog fl JOIN FETCH fl.foodItem " +
           "WHERE fl.user.id = :userId ORDER BY fl.logDate DESC")
    List<FoodLog> findAllByUserId(@Param("userId") Long userId);
}
