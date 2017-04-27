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
     * 
     * @return returnar registreringsnummer
     */
    public String getRegNumber() {
        return this.regNumber;
    }
}
