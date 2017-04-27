package se.kth.iv1350.vehicleInspection.DTO;

/**
 * DTO för ett kreditkort
 */
public class CreditCardDTO {
    private int number;
    
    CreditCardDTO(int number) {
        this.number = number;
    }
    
    public int getNumber() {
        return this.number;
    }
}
