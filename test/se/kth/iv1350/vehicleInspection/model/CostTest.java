package se.kth.iv1350.vehicleInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CostTest {

    /**
     * Kollar om rätt kostnad räknas ut
     */
    @Test
    public void testCorrectAmountCalculated() {
        PartToInspect[] partsToInspect = new PartToInspect[2];
        partsToInspect[0] = new PartToInspect("brakes");
        partsToInspect[1] = new PartToInspect("steering");
        Cost instance = new Cost(partsToInspect);
        
        float expResult = 20.0F;
        float result = instance.getAmount();
        
        assertEquals("Fel kostnad räknades ut för inspektionen!", expResult, result, 0.0);
    }    
    
    /**
     * Kollar om rätt kostnad räknas ut
     */
    @Test
    public void testIncorrectAmountCalculated() {
        PartToInspect[] partsToInspect = new PartToInspect[2];
        partsToInspect[0] = new PartToInspect("brakes");
        partsToInspect[1] = new PartToInspect("steering");
        Cost instance = new Cost(partsToInspect);
        
        float expResult = 30.0F;
        float result = instance.getAmount();
        
        assertNotEquals("Fel kostnad räknades ut för inspektionen!", expResult, result, 0.0);
    }    
}
