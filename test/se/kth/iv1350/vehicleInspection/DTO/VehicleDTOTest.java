package se.kth.iv1350.vehicleInspection.DTO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VehicleDTOTest {

    @Test
    public void testCreatedProperly() {
        String regNumber = "ABC123";
        VehicleDTO instance = new VehicleDTO(regNumber);
        
        String expResult = regNumber;
        String result = instance.getRegNumber();
        assertEquals("Något gick fel vid skapandet, rätt värde ligger inte i DTOns regNumber!", expResult, result);
    }
    
    @Test
    public void testEquals() {
        String regNumber = "ABC123";
        VehicleDTO instance = new VehicleDTO(regNumber);
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        
        boolean result = instance.equals(vehicle);
        boolean expResult = true;
        
        assertEquals("Equals returnar false trots att objekten är lika!", result, expResult);
    }
    
    @Test
    public void testNotEquals() {
        VehicleDTO instance = new VehicleDTO("ABC123");
        VehicleDTO vehicle = new VehicleDTO("XYZ789");
        
        boolean result = instance.equals(vehicle);
        boolean expResult = false;
        
        assertEquals("Equals returnar true trots att objekten är olika!", result, expResult);
    }
}
