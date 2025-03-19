package ru.vadim.home.dailycaloriecalculator.core.services;

import ru.vadim.home.dailycaloriecalculator.dto.CheckCaloriesReportResponse;
import ru.vadim.home.dailycaloriecalculator.dto.DailyReportResponse;

import java.time.LocalDate;

public interface ReportService{
    DailyReportResponse buildDailyUserReport(long userId, LocalDate date);
    CheckCaloriesReportResponse buildCheckCaloriesReport(long userId);
}
