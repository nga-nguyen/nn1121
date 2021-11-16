package com.nn1121;

import java.time.Month;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.*;

import java.time.temporal.WeekFields;
import java.util.Locale;

public class ChargeDaysCalculator {
    public int isLadder(int chargeDays, LocalDate date) {
        int days = chargeDays;

        if (isLaborDay(date) || isIndependenceDay(date))
        {
           days--;
        }

        return days;
    }

    public int isChainsaw (int chargeDays, LocalDate date) {
        int days = chargeDays;

        if (isWeekend(date))
        {
            days--;
        }

        return days;
    }

    public int isJackhammer (int chargeDays, LocalDate date) {
        int days = chargeDays;

        if ((isWeekend(date) || isIndependenceDay(date) || isLaborDay(date)))
        {
            days--;
        }

        // If Independence Day AND weekend then remove additional charge day to account for observed holiday
        // on the weekday (charge on the weekday, but not when it's a holiday)
        if (isIndependenceDay(date) && isWeekend(date)) {
            days--;
        }

        return days;
    }

    public boolean isIndependenceDay (LocalDate date) {
        Month month = date.getMonth();
        if (month == Month.JULY && date.getDayOfMonth() == 4) {
            return true;
        }

        return false;
    }

    public boolean isLaborDay (LocalDate date) {
        LocalDate ld = LocalDate.of(date.getYear(), Month.SEPTEMBER, 1);
        TemporalAdjuster ta = TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY);
        LocalDate laborDay = ld.with(ta);

        if (date.equals(laborDay)) {
            return true;
        }

        return false;
    }

    public boolean isWeekend (LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }

        return false;
    }

    public boolean isWeekday (LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek != DayOfWeek.SATURDAY || dayOfWeek != DayOfWeek.SUNDAY) {
            return true;
        }

        return false;
    }
}