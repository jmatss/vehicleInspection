package se.kth.iv1350.vehicleInspection.controller;

import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;
import se.kth.iv1350.vehicleInspection.integration.*;
import se.kth.iv1350.vehicleInspection.DTO.*;

/**
 * Controllern hanterar alla calls mellan view och resten av programmet
 */
public class Controller {
    private Printer printer;
    private InspectionRegistry inspectionRegistry;
    private PaymentAuthorization paymentAuthorization;
    
    /**
     * Skapar controllern och ger den referenser till objekt som den måste ha koll på
     * @param printer Tar hand om alla kalls till printern
     * @param inspectionRegistry Tar hand om alla calls till databasen
     * @param paymentAuthorization Tar hand om alla calls till payment auth. systemet
     */
    public Controller(Printer printer, InspectionRegistry inspectionRegistry,
            PaymentAuthorization paymentAuthorization) {
        this.printer = printer;
        this.inspectionRegistry =  inspectionRegistry;
        this.paymentAuthorization = paymentAuthorization;
    }
    
    /**
     * Öppnar garagedörren
     */
    public void openDoor() {
        
    }
    
    /**
     * Stänger garagedörren
     */
    public void closeDoor() {
        
    }
    
    /**
     * Hittar inspektioner som ska göras för fordonet och beräknar kostnaden som
     * returnas till denna metod.
     * @param vehicle Fordonet som ska inspekteras
     * @return Kostnaden för inspektionen
     */
    public Cost returnCostOfInspection(VehicleDTO vehicle) {
        
    }
    
    /**
     * Betalning av inspektion
     * @param card Kreditkortsinformation
     * @param inspection Inspektionen som ska betalas
     * @return True om betalningen gjordes, false om något gick fel
     */
    public boolean payment(CreditCardDTO card, Inspection inspection) {
        
    }
    
    /**
     * Hämtar nästa del som ska inspekteras
     * @param inspection Inspektionen som genomförs
     * @return Delen som ska inspekteras
     */
    public PartToInspect whatToInspect(Inspection inspection) {
        
    }
    
    /**
     * Godkänner delen som har inspekterats
     * @param inspection inspektionen som genomförs
     * @param partToInspect Delen som har godkänts
     */
    public void setPass(Inspection inspection, PartToInspect partToInspect) {
        
    }
    
    /**
     * Sparar en inspektion i databasen
     * @param inspection inspektionen som ska sparas
     */
    public void saveInspection(Inspection inspection) {
        
    }
}
