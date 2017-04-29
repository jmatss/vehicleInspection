package se.kth.iv1350.vehicleInspection.startup;

import se.kth.iv1350.vehicleInspection.integration.*;
import se.kth.iv1350.vehicleInspection.view.View;
import se.kth.iv1350.vehicleInspection.controller.Controller;

/**
 * Startar programmet
 */
public class Main {
    public static void main(String[] args){
        Printer printer = new Printer();
        InspectionRegistry inspectionRegistry = new InspectionRegistry();
        PaymentAuthorization paymentAuthorization = new PaymentAuthorization();
        
        Controller contr = new Controller(printer, inspectionRegistry, paymentAuthorization);
        
        View view = new View(contr);
        view.hardcodedCallsFromView();
    }
}
