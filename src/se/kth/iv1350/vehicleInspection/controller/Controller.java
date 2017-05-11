package se.kth.iv1350.vehicleInspection.controller;

import se.kth.iv1350.vehicleInspection.integration.*;
import se.kth.iv1350.vehicleInspection.DTO.*;
import se.kth.iv1350.vehicleInspection.model.*;



/**
 * Controllern hanterar alla calls mellan view och resten av programmet
 */
public class Controller {
    private Printer printer;
    private InspectionRegistry inspectionRegistry;
    private PaymentAuthorization paymentAuthorization;
    private Garage garage;
    private Queue queue;
    private Inspection currentInspection;
    
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
        
        this.garage = new Garage();
        this.queue = new Queue(new Display());
    }
    
    /**
     * Öppnar garagedörren och uppdaterar kön samt displayen
     */
    public void nextCustomer() {
        this.garage.openDoor();
        this.queue.updateQueue();
        
    }
    
    /**
     * Öppnar garagedörren
     */
    public void openDoor() {
        this.garage.openDoor();
    }
    
    /**
     * Stänger garagedörren
     */
    public void closeDoor() {
        this.garage.closeDoor();
    }
    
    /**
     * Hittar inspektion som ska göras för fordonet
     * @param vehicle Fordonet som ska inspekteras
     * @return Kostnaden för inspektionen
     */
    public Cost calculateAndReturnCostOfInspection(VehicleDTO vehicle) {
        this.currentInspection = this.inspectionRegistry.findInspection(vehicle);
        return this.currentInspection.getCost();
    }
    
    /**
     * Skriver ut receipt för nuvarande inspektion
     */
    public void printReceipt() {
        this.printer.printReceipt(this.currentInspection);
    }
    
    /**
     * Skriver ut inspektionsresultat för nuvarande inspektion
     */
    public void printResult() {
        this.printer.printResult(this.currentInspection);
    }
    
    /**
     * Betalning av inspektion
     * @param card Kreditkortsinformation
     * @return True om betalningen gjordes, false om något gick fel
     */
    public boolean payment(CreditCardDTO card) {
        boolean authorized = this.paymentAuthorization.authorizePayment(card, this.currentInspection.getCost());
        return authorized;
    }
    
    /**
     * Hämtar nästa del som ska inspekteras
     * @return Delen som ska inspekteras
     */
    public PartToInspect whatToInspect() {
        return this.currentInspection.getNextPartToInspect();
    }
    
    /**
     * 
     * @return nuvarande könumret
     */
    public int getCurrentQueueNumber() {
        return this.queue.getCurrentNumber();
    }
    
    /**
     * Godkänner delen som har inspekterats
     * @param partToInspect Delen som har godkänts
     */
    public void setResult(PartToInspect partToInspect, boolean result) {
        this.currentInspection.setResult(partToInspect, result);
    }
    
    /**
     * Sätter inspektionen till avklarad
     */
    public void setInspectionFinished() {
        this.currentInspection.setInspectionFinished();
    }
    
    /**
     * Sparar en inspektion i databasen
     */
    public void saveInspection() {
        this.inspectionRegistry.saveInspection(this.currentInspection);
    }
}
