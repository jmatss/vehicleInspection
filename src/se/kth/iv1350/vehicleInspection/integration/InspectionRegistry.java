package se.kth.iv1350.vehicleInspection.integration;

import se.kth.iv1350.vehicleInspection.model.Inspection;
import se.kth.iv1350.vehicleInspection.DTO.VehicleDTO;
/**
 * Tar hand om alla calls till inspektionsdatabasen
 */
public class InspectionRegistry {
    /**
     * Hittar alla inspektioner för inmatade vehicle
     * @param vehicle Används för att hitta alla inspektioner för detta vehicle
     * @return returnar en array av alla inspektioner för ett specifikt vehicle
     */
    public Inspection[] findInspections(VehicleDTO vehicle){
        return ;
    }
    /**
     * Sparar en inspecktion i databasen
     * @param inspection Inspektionen som ska sparas
     */
    public void saveInspection(Inspection inspection) {
        
    }
}
