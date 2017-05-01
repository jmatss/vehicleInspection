package se.kth.iv1350.vehicleInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DisplayTest {
    /**
     * Test of showOnDisplay method, of class Display.
     */
    @Test
    public void testShowOnDisplay() {
        int currentNumber = 12;
        Display instance = new Display();
        instance.showOnDisplay(currentNumber);
        int result = instance.getNumberOnDisplay();
        assertEquals("Numret på displayen uppdaterades inte korrekt!", currentNumber, result);
    }
    
}
