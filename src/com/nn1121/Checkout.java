package com.nn1121;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Checkout {
    public static final BigDecimal TOOL_TYPE_LADDER_DAILY_CHARGE = new BigDecimal("1.99");
    public static final BigDecimal TOOL_TYPE_CHAINSAW_DAILY_CHARGE = new BigDecimal("1.49");
    public static final BigDecimal TOOL_TYPE_JACKHAMMER_DAILY_CHARGE = new BigDecimal("2.99");

    public Checkout() {
    }

    public RentalAgreement checkoutTool (String toolCode, int rentalDayCount, int discountPercent, LocalDate checkoutDate) throws Exception {
        ChargeDaysCalculator day = new ChargeDaysCalculator();
        RentalAgreement rentalAgreement = new RentalAgreement();
        Tools toolMapper;
        LocalDate rentalDaysIterator;
        int chargeDays = 0;

        if (rentalDayCount < 1) {
            throw new Exception("Rental day count should be 1 or more.");
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new Exception("Discount percent should be in the range of 0-100.");
        }

        // Mapping the tool to its tool type.
        toolMapper = new Tools(toolCode);
        rentalAgreement.setToolType(toolMapper.getToolType());
        rentalAgreement.setToolBrand(toolMapper.getToolBrand());
        rentalAgreement.setToolCode(toolMapper.getToolCode());

        rentalAgreement.setRentalDays(rentalDayCount);
        rentalAgreement.setCheckoutDate(checkoutDate);
        LocalDate due = checkoutDate.plusDays(rentalDayCount);
        rentalAgreement.setDueDate(due);
        rentalAgreement.setDiscountPercent(discountPercent);


        switch (toolCode) {
            case Tools.TOOL_CODE_LADW:
                rentalAgreement.setDailyRentalCharge(TOOL_TYPE_LADDER_DAILY_CHARGE);
                break;
            case Tools.TOOL_CODE_CHNS:
                rentalAgreement.setDailyRentalCharge(TOOL_TYPE_CHAINSAW_DAILY_CHARGE);
                break;
            case Tools.TOOL_CODE_JAKR:
                rentalAgreement.setDailyRentalCharge(TOOL_TYPE_JACKHAMMER_DAILY_CHARGE);
                break;
            case Tools.TOOL_CODE_JAKD:
                rentalAgreement.setDailyRentalCharge(TOOL_TYPE_JACKHAMMER_DAILY_CHARGE);
                break;
        }

        rentalDaysIterator = checkoutDate;
        chargeDays = rentalDayCount;

        for (int i = 0; i < rentalDayCount; i++) {
            rentalDaysIterator = rentalDaysIterator.plusDays(1);

            switch (toolCode) {
                case Tools.TOOL_CODE_LADW:
                    chargeDays = day.isLadder(chargeDays, rentalDaysIterator);
                    break;
                case Tools.TOOL_CODE_CHNS:
                    chargeDays = day.isChainsaw(chargeDays, rentalDaysIterator);
                    break;
                case Tools.TOOL_CODE_JAKR:
                    chargeDays = day.isJackhammer(chargeDays, rentalDaysIterator);
                    break;
                case Tools.TOOL_CODE_JAKD:
                    chargeDays = day.isJackhammer(chargeDays, rentalDaysIterator);
                    break;
            }
        }

        BigDecimal amount = rentalAgreement.getDailyRentalCharge().multiply(BigDecimal.valueOf(chargeDays));
        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);

        rentalAgreement.setChargeDays(chargeDays);
        rentalAgreement.setPrediscountCharge(amount);

        if (discountPercent > 0 && discountPercent < 100) {
            amount = rentalAgreement.getPrediscountCharge();
            amount = amount.multiply(BigDecimal.valueOf(discountPercent).movePointLeft(2));
            amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        else if (discountPercent == 100) {
            amount = rentalAgreement.getPrediscountCharge();
        }
        else {
            amount = new BigDecimal("0.00");
        }

        rentalAgreement.setDiscountAmount(amount);
        rentalAgreement.setFinalCharge(rentalAgreement.getPrediscountCharge().subtract(rentalAgreement.getDiscountAmount()));

        return rentalAgreement;
    }

    public static void printRentalAgreement (RentalAgreement rentalAgreement) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        NumberFormat amountFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();

        System.out.println("Tool code: " + rentalAgreement.getToolCode());
        System.out.println("Tool type: " + rentalAgreement.getToolType());
        System.out.println("Tool brand: " + rentalAgreement.getToolBrand());
        System.out.println("Rental days: " + rentalAgreement.getRentalDays());
        System.out.println("Check out date: " + dateFormatter.format(rentalAgreement.getCheckoutDate()));
        System.out.println("Due date: " + dateFormatter.format(rentalAgreement.getDueDate()));
        System.out.println("Daily rental charge: " + amountFormatter.format(rentalAgreement.getDailyRentalCharge()));
        System.out.println("Charge days: " + rentalAgreement.getChargeDays());
        System.out.println("Pre-discount charge: " + amountFormatter.format(rentalAgreement.getPrediscountCharge()));
        System.out.println("Discount percent: " + percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))));
        System.out.println("Discount amount: " + amountFormatter.format(rentalAgreement.getDiscountAmount()));
        System.out.println("Final charge: " + amountFormatter.format(rentalAgreement.getFinalCharge()));
    }
}