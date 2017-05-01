package se.kth.iv1350.vehicleInspection.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.iv1350.vehicleInspection.DTO.CreditCardDTO;
import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;
import se.kth.iv1350.vehicleInspection.integration.InspectionRegistry;
import se.kth.iv1350.vehicleInspection.integration.PaymentAuthorization;
import se.kth.iv1350.vehicleInspection.integration.Printer;
import se.kth.iv1350.vehicleInspection.model.Cost;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;

public class ControllerTest {
    private Printer printer;
    private InspectionRegistry inspectionRegistry;
    private PaymentAuthorization paymentAuthorization;
    private Controller instance;

    @Before
    public void setUp() {
        this.printer = new Printer();
        this.inspectionRegistry = new InspectionRegistry();
        this.paymentAuthorization = new PaymentAuthorization();
        
        this.instance = new Controller(this.printer, this.inspectionRegistry, this.paymentAuthorization);
    }
    
    @After
    public void tearDown() {
        this.printer = null;
        this.inspectionRegistry = null;
        this.paymentAuthorization = null;
        
        this.instance = null;
    }

    /*
        Det finns många metoder i denna klass som jag inte vet hur jag ska testa.
        Metoderna returnar ingenting och ändrar endast värden i klasser som
        jag inte kan komma åt från controllklassen. Skriver mer i diskussionsdelen.
    */
    /**
     * Test of calculateAndReturnCostOfInspection method, of class Controller.
     */
    @Test
    public void testCalculateAndReturnCostOfInspection() {
        String regNumber = "ABC123";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        
        float expResult = 30.0F;
        float result = this.instance.calculateAndReturnCostOfInspection(vehicle).getAmount();
        
        assertEquals("Något gick fel vid hämtning av inspektion från databasen"
                + "och uträkning av kostnad", expResult, result, 0.0);
    }
    
    /**
     * Test of calculateAndReturnCostOfInspection method, of class Controller.
     */
    @Test
    public void testCalculateAndReturnCostOfInspectionFail() {
        String regNumber = "XYZ789";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        
        float expResult = 30.0F;
        float result = this.instance.calculateAndReturnCostOfInspection(vehicle).getAmount();
        
        assertNotEquals("Något gick fel vid hämtning av inspektion från databasen"
                + "och uträkning av kostnad", expResult, result, 0.0);
    }

    /**
     * Test of payment method, of class Controller.
     */
    @Test
    public void testPayment() {
        CreditCardDTO card = null;
        
        String regNumber = "ABC123";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        this.instance.calculateAndReturnCostOfInspection(vehicle);

        boolean result = this.instance.payment(card);
        assertTrue("Payment returnerade false trots att den bör returnat true", result);
    }

    /**
     * Test of whatToInspect method, of class Controller.
     * Skapar en inspektion manuellt och en via InspectionRegistry(hämtas från "databasen").
     * Sedan kollar man om inspektionen hämtas korrekt av funktionen whatToInspect.
     */
    @Test
    public void testWhatToInspect() {
        boolean result = true;
        boolean expResult = true;
        
        PartToInspect[] manuallyCreatedPartsToInspect = new PartToInspect[3];
        manuallyCreatedPartsToInspect[0] = new PartToInspect("brakes");
        manuallyCreatedPartsToInspect[1] = new PartToInspect("suspension");
        manuallyCreatedPartsToInspect[2] = new PartToInspect("steering");
        
        String regNumber = "ABC123";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        this.instance.calculateAndReturnCostOfInspection(vehicle);
        
        PartToInspect fromDatabasePartToInspect;
        
        int i = 0;
        while((fromDatabasePartToInspect = this.instance.whatToInspect()) != null) {
  
            if (!fromDatabasePartToInspect.equals(manuallyCreatedPartsToInspect[i++])) {
                result = false;
                break;
            }
        }
        
        assertEquals("Korrekt inspektion hämtades inte!" ,expResult, result);
    }
    
}
