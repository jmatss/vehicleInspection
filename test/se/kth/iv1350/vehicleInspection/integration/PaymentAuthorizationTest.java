package se.kth.iv1350.vehicleInspection.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.CreditCardDTO;
import se.kth.iv1350.vehicleInspection.model.Cost;

public class PaymentAuthorizationTest {

    /**
     * Test of authorizePayment method, of class PaymentAuthorization.
     */
    @Test
    public void testAuthorizePayment() {
        CreditCardDTO card = null;
        Cost cost = null;
        PaymentAuthorization instance = new PaymentAuthorization();
        
        boolean expResult = true;
        boolean result = instance.authorizePayment(card, cost);
        assertEquals("Någonting gick fel vid betalning, blev inte authade!", expResult, result);
    }
    
}
