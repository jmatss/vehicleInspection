package se.kth.iv1350.vehicleInspection.DTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardDTOTest {

    @Test
    public void testCreatedProperly() {
        String cardNumber = "123456789";
        CreditCardDTO instance = new CreditCardDTO(cardNumber);
        
        String expResult = cardNumber;
        String result = instance.getNumber();
        assertEquals("Något gick fel vid skapandet, rätt värde ligger inte i DTOns Number!", expResult, result);
    }
    
}
