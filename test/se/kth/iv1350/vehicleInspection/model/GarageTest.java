package se.kth.iv1350.vehicleInspection.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GarageTest {
    
    @Test
    public void testOpenDoor() {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Garage instance = new Garage();
        instance.openDoor();

        String expResult = "Door open!";
        String result = outContent.toString();

        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));
        outContent = null;
        System.setOut(originalSysout);
    }
    
    @Test
    public void testCloseDoor() {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        Garage instance = new Garage();
        instance.closeDoor();

        String expResult = "Door closed!";
        String result = outContent.toString();

        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));
        outContent = null;
        System.setOut(originalSysout);
    }
    
}
