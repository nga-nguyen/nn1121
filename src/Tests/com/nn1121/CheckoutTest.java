package com.nn1121;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Locale;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CheckoutTest {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    NumberFormat amountFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    @Test
    public void Test1()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_JAKR;
        LocalDate checkoutDate = LocalDate.of(2015, 9, 3);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 5, 101, checkoutDate);

            assertEquals("Checkout Exception: ", rentalAgreement, "Discount percent should be in the range of 0-100.");
//            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "JAKR");
//            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Jackhammer");
//            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "Ridgid");
//            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 5);
//            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "09/03/2015");
//            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "09/08/2015");
//            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$2.99");
//            //assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 2);
//            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$5.98");
//            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "101%");
//            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$6.04");
//            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "-$0.06");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test1()]

    @Test
    public void Test2()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_LADW;
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 3, 10, checkoutDate);

            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "LADW");
            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Ladder");
            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "Werner");
            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 3);
            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "07/02/2020");
            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "07/05/2020");
            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$1.99");
            assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 2);
            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$3.98");
            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "10%");
            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$0.40");
            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "$3.58");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test2()]

    @Test
    public void Test3()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_CHNS;
        LocalDate checkoutDate = LocalDate.of(2015, 7, 2);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 5, 25, checkoutDate);

            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "CHNS");
            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Chainsaw");
            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "Stihl");
            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 5);
            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "07/02/2015");
            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "07/07/2015");
            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$1.49");
            assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 3);
            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$4.47");
            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "25%");
            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$1.12");
            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "$3.35");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test3()]

    @Test
    public void Test4()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_JAKD;
        LocalDate checkoutDate = LocalDate.of(2015, 9, 3);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 6, 0, checkoutDate);

            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "JAKD");
            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Jackhammer");
            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "DeWalt");
            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 6);
            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "09/03/2015");
            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "09/09/2015");
            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$2.99");
            assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 3);
            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$8.97");
            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "0%");
            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$0.00");
            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "$8.97");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test4()]

    @Test
    public void Test5()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_JAKR;
        LocalDate checkoutDate = LocalDate.of(2015, 7, 2);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 9, 0, checkoutDate);

            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "JAKR");
            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Jackhammer");
            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "Ridgid");
            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 9);
            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "07/02/2015");
            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "07/11/2015");
            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$2.99");
            assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 5);
            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$14.95");
            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "0%");
            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$0.00");
            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "$14.95");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test5()]

    @Test
    public void Test6()
    {
        Checkout checkout = new Checkout();

        String toolCode = Tools.TOOL_CODE_JAKR;
        LocalDate checkoutDate = LocalDate.of(2020, 7, 2);

        try {
            RentalAgreement rentalAgreement = checkout.checkoutTool(toolCode, 4, 50, checkoutDate);

            assertEquals("Tool code: ", rentalAgreement.getToolCode(), "JAKR");
            assertEquals("Tool type: ", rentalAgreement.getToolType(), "Jackhammer");
            assertEquals("Tool brand: ", rentalAgreement.getToolBrand(), "Ridgid");
            assertEquals("Rental days: ", rentalAgreement.getRentalDays(), 4);
            assertEquals("Check out date: ", dateFormatter.format(rentalAgreement.getCheckoutDate()), "07/02/2020");
            assertEquals("Due date: ", dateFormatter.format(rentalAgreement.getDueDate()), "07/06/2020");
            assertEquals("Daily rental charge: ", amountFormatter.format(rentalAgreement.getDailyRentalCharge()), "$2.99");
            assertEquals("Charge days: ", rentalAgreement.getChargeDays(), 1);
            assertEquals("Pre-discount charge: ", amountFormatter.format(rentalAgreement.getPrediscountCharge()), "$2.99");
            assertEquals("Discount percent: ", percentFormatter.format(new BigDecimal(rentalAgreement.getDiscountPercent()).divide(new BigDecimal(100))), "50%");
            assertEquals("Discount amount: ", amountFormatter.format(rentalAgreement.getDiscountAmount()), "$1.50");
            assertEquals("Final charge: ", amountFormatter.format(rentalAgreement.getFinalCharge()), "$1.49");

            checkout.printRentalAgreement(rentalAgreement);
        } catch (Exception error)
        {
            System.out.println("Error: " + error);
        }
    } // [END: Test6()]
}