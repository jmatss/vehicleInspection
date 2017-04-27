package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.DTO.CreditCardDTO;
/**
 * Hanterar alla calls till payment auth. systemet
 */
public class PaymentAuthorization {
    /**
     * Används för att authorizea betalningar
     * @param card Kreditkorts information
     * @param inspection Inspektionen som ska betalas
     * @return 
     */
    public boolean authorizePayment(CreditCardDTO card, Inspection inspection) {
        
    }
}
