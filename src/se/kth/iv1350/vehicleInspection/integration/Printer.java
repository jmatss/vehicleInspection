package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.Inspection;
/**
 * Sköter utskrifter av receipts och inspection results
 */
public class Printer {
    /**
     * Skriver ut receipt
     * @param inspection inspektionen som ska skrivas ut
     */
    public void printReceipt(Inspection inspection){
        System.out.println("Receipt har skrivits ut!");
    }
    /**
     * Skriver ut inspekationsresultat
     * @param inspection inspektionen som ska skrivas ut
     */
    public void printResult(Inspection inspection){
        System.out.println("Inspection results har skrivits ut!");
    }
}
