package se.kth.iv1350.vehicleInspection.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;
import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;

public class InspectionRegistryTest {

    /**
     * Test of findInspection method, of class InspectionRegistry.
     * Skapar en inspektion manuellt och en via InspectionRegistry(hämtas från "databasen").
     * Sedan jämförs inspektionerna som borde vara lika
     */
    @Test
    public void testCorrectInspectionFound() {
        PartToInspect[] partsToInspect = new PartToInspect[3];
        partsToInspect[0] = new PartToInspect("brakes");
        partsToInspect[1] = new PartToInspect("suspension");
        partsToInspect[2] = new PartToInspect("steering");

        String regNumber = "ABC123";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        Inspection inspection = new Inspection(vehicle, partsToInspect);
        
        InspectionRegistry instance = new InspectionRegistry();

        boolean expResult = true;
        boolean result = instance.findInspection(vehicle).equals(inspection);
        
        assertEquals("Rätt inspektion hämtades inte ur databasen!", result, expResult);
    }
    
    /**
     * Test of findInspection method, of class InspectionRegistry.
     * Skapar en inspektion manuellt och en via InspectionRegistry(hämtas från "databasen").
     * Sedan jämförs inspektionerna som borde vara olika
     */
    @Test
    public void testIncorrectInspectionFound() {
        PartToInspect[] partsToInspect = new PartToInspect[3];
        partsToInspect[0] = new PartToInspect("brakes");
        partsToInspect[1] = new PartToInspect("suspension");
        partsToInspect[2] = new PartToInspect("steering");

        String regNumber = "ABC123";
        String anotherRegNumber = "XYZ789";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        VehicleDTO anotherVehicle = new VehicleDTO(anotherRegNumber);
        
        Inspection inspection = new Inspection(vehicle, partsToInspect);
        
        InspectionRegistry instance = new InspectionRegistry();
        
        boolean expResult = false;
        boolean result = instance.findInspection(anotherVehicle).equals(inspection);
        
        assertEquals("Rätt inspektion hämtades inte ur databasen!", result, expResult);
    }
    
    /**
     * Test of saveInspection method, of class InspectionRegistry.
     */
    @Test
    public void testSaveInspection() {
        PrintStream originalSysout = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PartToInspect[] partsToInspect = new PartToInspect[1];
        partsToInspect[0] = new PartToInspect("brakes");
        
        Inspection inspection = new Inspection(null, partsToInspect);
        InspectionRegistry instance = new InspectionRegistry();
        instance.saveInspection(inspection);

        String expResult = "Resultat sparat i databasen!";
        String result = outContent.toString();
        assertTrue("Texten skrivs inte korrekt till system.out!", result.contains(expResult));

        outContent = null;
        System.setOut(originalSysout);
    }
    
}
