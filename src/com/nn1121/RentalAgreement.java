package com.nn1121;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentalAgreement {
    public String toolCode;
    public String toolType;
    public String toolBrand;

    public int rentalDays;
    public int chargeDays;
    public int discountPercent;

    public LocalDate checkoutDate;
    public LocalDate dueDate;

    public BigDecimal dailyRentalCharge;
    public BigDecimal prediscountCharge;
    public BigDecimal discountAmount;
    public BigDecimal finalCharge;

    public String getToolCode() { return toolCode; }

    public String getToolType() {
        return toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BigDecimal getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public BigDecimal getPrediscountCharge() {
        return prediscountCharge;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getFinalCharge() {
        return finalCharge;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setDailyRentalCharge(BigDecimal dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public void setPrediscountCharge(BigDecimal prediscountCharge) {
        this.prediscountCharge = prediscountCharge;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setFinalCharge(BigDecimal finalCharge) {
        this.finalCharge = finalCharge;
    }
}
