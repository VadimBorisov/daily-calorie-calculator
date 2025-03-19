package ru.vadim.home.dailycaloriecalculator.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vadim.home.dailycaloriecalculator.core.services.ReportService;
import ru.vadim.home.dailycaloriecalculator.dto.CheckCaloriesReportResponse;
import ru.vadim.home.dailycaloriecalculator.dto.DailyReportResponse;

import java.time.LocalDate;

@RestController
@RequestMapping("/calories-calculator/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{userId}/dailySummary")
    public DailyReportResponse getDailySummary(@PathVariable("userId") long userId) {
        return reportService.buildDailyUserReport(userId, LocalDate.now());
    }

    @GetMapping("/{userId}/checkDailySummary")
    public CheckCaloriesReportResponse checkDailySummary(@PathVariable("userId") long userId) {
        return reportService.buildCheckCaloriesReport(userId);
    }

    @GetMapping("/{userId}/{date}")
    public DailyReportResponse getHistoricalByDate(@PathVariable("userId") long userId,
                                                            @PathVariable("date")
                                                   @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return reportService.buildDailyUserReport(userId, date);
    }
}
