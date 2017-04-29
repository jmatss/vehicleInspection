package se.kth.iv1350.vehicleInspection.view;

import se.kth.iv1350.vehicleInspection.controller.Controller;
import se.kth.iv1350.vehicleInspection.DTO.*;
import se.kth.iv1350.vehicleInspection.model.Cost;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;

/**
 * All in- och utmatning sker via denna klass
 */
public class View {
    private Controller contr;
    
    /**
     * skapar view
     * @param contr ger view en referens till controllern
     */
    public View(Controller contr) {
        this.contr = contr;
    }
    
    /**
     * All in- och utmatning sker via denna metod
     */
    public void hardcodedCallsFromView() {
        // rad 1-3 i kravspecifikationen
        System.out.println("VIEW in: Ny inspektion");
        this.contr.nextCustomer();
        
        // rad 4-5
        System.out.println("VIEW in: Stäng dörren");
        this.contr.closeDoor();
        
        // rad 6-8
        System.out.println("VIEW in: Inspektör skriver in regnummer");
        String regNumber = "XYZ789";
        VehicleDTO vehicle = new VehicleDTO(regNumber);
        Cost cost = this.contr.calculateAndReturnCostOfInspection(vehicle);
        System.out.println("VIEW out: Kostnad för denna inspektion(regnr "
                + vehicle.getRegNumber() + "): " + cost.getAmount() + "kr");
        
        // rad 9-12
        System.out.println("VIEW in: Kund skriver in kreditkortsinformation");
        String cardNumber = "123456789";
        CreditCardDTO card = new CreditCardDTO(cardNumber);
        boolean authorized = this.contr.payment(card);   // använder inte authorized, returnar ändå alltid true och behöver inte koda för false
        this.contr.printReceipt();
        
        // rad 13-17
        PartToInspect partToInspect;
        boolean passed = true;
        
        // loopar igenom alla delar och sätter resultatet till true(godkänt).
        // Om inspektionen av en del inte blir godkänd behövs ingen kod köras,
        // eftersom att partToInspect blev satt till icke godkänd("fail") när den skapades
        while ((partToInspect = this.contr.whatToInspect()) != null) {
            System.out.println("VIEW in/out: Inspektör frågar vilken del som ska inspekteras,"
                    + " får tilbaka: " + partToInspect.getName());
            
            if(passed)
                this.contr.setPass(partToInspect);
            
            System.out.println("VIEW in: delinspektion godkänd(" + partToInspect.getName()
                    + ", Pass: " + partToInspect.getResult() + ")");
        }
        this.contr.setInspectionFinished();
        System.out.println("Inspektion avklarad");
        
        // rad 18-20
        this.contr.saveInspection();
        this.contr.printResult();
                
        // rad 21-23
        this.contr.openDoor();
        this.contr.closeDoor();
    }
}
