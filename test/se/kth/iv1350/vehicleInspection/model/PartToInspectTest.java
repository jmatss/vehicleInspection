package se.kth.iv1350.vehicleInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PartToInspectTest {

    /**
     * Test of equals method, of class PartToInspect.
     */
    @Test
    public void testEquals() {
        PartToInspect instance = new PartToInspect("brakes");
        PartToInspect partToInspect = new PartToInspect("brakes");
        
        boolean expResult = true;
        boolean result = instance.equals(partToInspect);
        assertEquals("equals returnerade false trots att namnen är samma!", expResult, result);
    }
    
    /**
     * Test of equals method, of class PartToInspect.
     */
    @Test
    public void testNotEquals() {
        PartToInspect instance = new PartToInspect("brakes");
        PartToInspect partToInspect = new PartToInspect("steering");
        
        boolean expResult = false;
        boolean result = instance.equals(partToInspect);
        assertEquals("equals returnerade true trots att namnen är olika!", expResult, result);
    }

    /**
     * Test of setPass method, of class PartToInspect.
     */
    @Test
    public void testSetPass() {
        PartToInspect instance = new PartToInspect("brakes");
        instance.setPass();
        
        boolean expResult = true;
        boolean result = instance.getResult();
        assertEquals("Resultatet sätts inte rätt!", result, expResult);
    }
    
}
