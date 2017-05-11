package se.kth.iv1350.vehicleInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;

public class InspectionTest {
    VehicleDTO vehicle;
    PartToInspect[] partsToInspect;
    Inspection instance;
    
    @Before
    public void setUp() {
        String regNumber = "ABC123";
        this.vehicle = new VehicleDTO(regNumber);
        
        this.partsToInspect = new PartToInspect[1];
        this.partsToInspect[0] = new PartToInspect("brakes");
        
        this.instance = new Inspection(this.vehicle, this.partsToInspect);
    }
    
    @After
    public void tearDown() {
        this.vehicle = null;
        this.partsToInspect = null;
        this.instance = null;
    }

    /**
     * Test of equals method, of class Inspection.
     */
    @Test
    public void testEquals() {
        Inspection inspection = new Inspection(this.vehicle, this.partsToInspect);

        boolean result = this.instance.equals(inspection);
        assertTrue("equals returnade false trots att inspektionerna är lika!",result);
    }
    
    /**
     * Test of equals method, of class Inspection.
     */
    @Test
    public void testregNumberNotEquals() {
        String otherRegNumber = "XYZ789";
        VehicleDTO otherVehicle = new VehicleDTO(otherRegNumber);
                
        Inspection inspection = new Inspection(otherVehicle, this.partsToInspect);
        
        boolean result = this.instance.equals(inspection);
        assertFalse("equals returnade true trots att inspektionernas vehicles är olika!",result);
    }
    
    /**
     * Test of equals method, of class Inspection.
     */
    @Test
    public void testAmountOfPartsNotEquals() {
        PartToInspect[] otherPartsToInspect = new PartToInspect[2];
        otherPartsToInspect[0] = new PartToInspect("brakes");
        otherPartsToInspect[1] = new PartToInspect("steering");
        
        Inspection inspection = new Inspection(this.vehicle, otherPartsToInspect);

        boolean result = this.instance.equals(inspection);
        assertFalse("equals returnade true trots att inspektionerna har olika antal delar!",result);
    }

    
    /**
     * Test of equals method, of class Inspection.
     */
    @Test
    public void testPartNamesNotEquals() {
        PartToInspect[] otherPartsToInspect = new PartToInspect[1];
        otherPartsToInspect[0] = new PartToInspect("steering");
                
        Inspection inspection = new Inspection(this.vehicle, otherPartsToInspect);

        boolean result = this.instance.equals(inspection);
        assertFalse("equals returnade true trots att inspektionerna har olika namn på delarna!",result);
    }

    /**
     * Test of getVehicle method, of class Inspection.
     */
    @Test
    public void testGetVehicle() {
        VehicleDTO expResult = null;
        boolean result = this.vehicle.equals(this.instance.getVehicle());
        assertTrue("Rätt vehicle hämtas inte från inspektionsklassen!",result);

    }

    /**
     * Test of getInspectionFinished method, of class Inspection.
     * and
     * Test of setInspectionFinished method, of class Inspection.
     */
    @Test
    public void testSetAndGetInspectionFinished() {
        this.instance.setInspectionFinished();
        boolean result = this.instance.getInspectionFinished();
        assertTrue("Metoderna sätter eller hämtar värdet av inspectionFinished fel!", result);

    }

    /**
     * Test of getNextPartToInspect method, of class Inspection.
     * Skapar en array med samma partsToInspect som "instance" objektet.
     * Sedan jämför jag och ser att funktionen hämtar rätt parts.
     */
    @Test
    public void testGetNextPartToInspect() {
        boolean result = true;
        PartToInspect[] otherPartsToInspect = new PartToInspect[1];
        otherPartsToInspect[0] = new PartToInspect("brakes");
        
        PartToInspect partToInspectFromInstance;
        
        int i = 0;
        while((partToInspectFromInstance = this.instance.getNextPartToInspect()) != null)
            if(!partToInspectFromInstance.equals(otherPartsToInspect[i++]))
                result = false;
   
        assertTrue("Fel parts hämtas ifrån this.instance!", result);
    }

    /**
     * Test of setPass method, of class Inspection.
     */
    @Test
    public void testSetResult() {
        boolean partInspectionResult = true;
        this.instance.setResult(this.partsToInspect[0], partInspectionResult);
        
        boolean result = this.partsToInspect[0].getResult();
        assertTrue("Resultat för en delinspektion sätts inte korrekt!", result);
    }

    /**
     * Test of getCost method, of class Inspection.
     */
    @Test
    public void testGetCost() {
        float expResult = 10.0F;
        float result = this.instance.getCost().getAmount();
        assertEquals("Kostnaden hämtades eller räknades inte ut korrekt!",expResult, result, 0.0);
    }
    
}
