package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.model.PartToInspect;
import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;
/**
 * Tar hand om alla calls till och från inspektionsdatabasen
 */
public class InspectionRegistry {
    /**
     * Hittar inspektion för inmatade vehicle
     * @param vehicle Används för att hitta alla inspektioner för detta vehicle
     * @return returnar inspekition som ska göras
     */
    public Inspection findInspection(VehicleDTO vehicle){
        Inspection inspection = null;
        PartToInspect[] partsToInspect = null;
        
        if (vehicle.getRegNumber().equals("ABC123")) {
            partsToInspect = new PartToInspect[3];
            partsToInspect[0] = new PartToInspect("brakes");
            partsToInspect[1] = new PartToInspect("suspension");
            partsToInspect[2] = new PartToInspect("steering");

            inspection = new Inspection(vehicle, partsToInspect);
        }
        
        if (vehicle.getRegNumber().equals("XYZ789")) {
            partsToInspect = new PartToInspect[2];
            partsToInspect[0] = new PartToInspect("brakes");
            partsToInspect[1] = new PartToInspect("suspension");

            inspection = new Inspection(vehicle, partsToInspect);
        }
        return inspection;
    }
    
    /**
     * Sparar en inspecktion i databasen
     * @param inspection Inspektionen som ska sparas
     */
    public void saveInspection(Inspection inspection) {
        System.out.println("Resultat sparat i databasen!");
    }
}
