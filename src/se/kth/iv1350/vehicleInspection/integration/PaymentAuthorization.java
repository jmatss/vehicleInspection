package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.Cost;
import se.kth.iv1350.vehicleInspection.DTO.CreditCardDTO;
/**
 * Hanterar alla calls till payment auth. systemet
 */
public class PaymentAuthorization {
    /**
     * Används för att authorizea betalningar
     * @param card Kreditkorts information
     * @param cost Kostnaden som ska betalas
     * @return true om betalningen funkade, false om något gick fel
     */
    public boolean authorizePayment(CreditCardDTO card, Cost cost) {
        System.out.println("Payment authorized!");
        return true;
    }
}
