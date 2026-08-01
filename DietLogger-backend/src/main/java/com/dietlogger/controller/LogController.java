package com.dietlogger.controller;

import com.dietlogger.config.CustomUserDetails;
import com.dietlogger.dto.DailyTotalsResponse;
import com.dietlogger.dto.HistoryEntryResponse;
import com.dietlogger.dto.LogRequest;
import com.dietlogger.service.LogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<DailyTotalsResponse> logFood(
            @AuthenticationPrincipal CustomUserDetails user,
            @Valid @RequestBody LogRequest request) {
        return ResponseEntity.ok(logService.logFood(user.getId(), request.getFoodItemId()));
    }

    @GetMapping("/today")
    public ResponseEntity<DailyTotalsResponse> getTodayTotals(@AuthenticationPrincipal CustomUserDetails user) {
        return ResponseEntity.ok(logService.getTodayTotals(user.getId()));
    }

    @GetMapping("/history")
    public ResponseEntity<List<HistoryEntryResponse>> getHistory(@AuthenticationPrincipal CustomUserDetails user) {
        return ResponseEntity.ok(logService.getHistory(user.getId()));
    }
}
