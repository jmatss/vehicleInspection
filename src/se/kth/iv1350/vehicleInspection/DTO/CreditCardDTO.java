package se.kth.iv1350.vehicleInspection.DTO;

/**
 * DTO för ett kreditkort
 */
public class CreditCardDTO {
    private String number;
    
    /**
     * Skapar ett kreditkort
     * @param number kortnumret
     */
    public CreditCardDTO(String number) {
        this.number = number;
    }
    
    /**
     * returnar kortnumret
     * @return kortnumret
     */
    public String getNumber() {
        return this.number;
    }
}
