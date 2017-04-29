package se.kth.iv1350.vehicleInspection.DTO;

/**
 * DTO för ett fordon
 */
public class VehicleDTO {
    private String regNumber;
    
    /**
     * Skapar ett vehicle
     * @param regNumber Registreringsnummer på fordonet
     */
    public VehicleDTO(String regNumber) {
        this.regNumber = regNumber;
    }
    
    /**
     * Jämför regnummer på två vehicles
     * @param obj ska jämföras med detta objekt
     * @return true om regnumrena är lika, false om dom är olika
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof VehicleDTO))
            return false;
        VehicleDTO vehicle = (VehicleDTO)obj;
        
        return (this.regNumber == vehicle.getRegNumber());
    }
    
    /**
     * 
     * @return returnar registreringsnummer
     */
    public String getRegNumber() {
        return this.regNumber;
    }
}
