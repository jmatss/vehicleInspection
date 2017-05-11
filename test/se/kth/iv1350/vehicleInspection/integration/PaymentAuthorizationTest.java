package se.kth.iv1350.vehicleInspection.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.*;
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
    
    @Test
    public void testAutorizePaymentText()
    {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        CreditCardDTO card = null;
        Cost cost = null;
        PaymentAuthorization instance = new PaymentAuthorization();
        instance.authorizePayment(card, cost);

        String expResult = "Payment authorized!";
        String result = outContent.toString();
        
        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));
        outContent = null;
        System.setOut(originalSysout);
    }
    
}
