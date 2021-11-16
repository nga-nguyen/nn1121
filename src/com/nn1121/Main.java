package com.nn1121;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        RentalAgreement rentalAgreement;

        try {
            System.out.println("Test 1: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_JAKR, 5, 101, LocalDate.of(2015, 9, 3));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");

            System.out.println("Test 2: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_LADW, 3, 10, LocalDate.of(2020, 7, 2));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");

            System.out.println("Test 3: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_CHNS, 5, 25, LocalDate.of(2015, 7, 2));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");

            System.out.println("Test 4: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_JAKD, 6, 0, LocalDate.of(2015, 9, 3));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");

            System.out.println("Test 5: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_JAKR, 9, 0, LocalDate.of(2015, 7, 2));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");

            System.out.println("Test 6: ");
            rentalAgreement = checkout.checkoutTool(Tools.TOOL_CODE_JAKR, 4, 50, LocalDate.of(2020, 7, 2));
            Checkout.printRentalAgreement(rentalAgreement);

            System.out.println("-----------");
            System.out.println("");
        }
        catch(Exception e)
        {
            System.out.println(e + "An error has occurred.");
        }
    }
}
