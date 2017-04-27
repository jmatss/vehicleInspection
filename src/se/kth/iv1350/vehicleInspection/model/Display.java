package se.kth.iv1350.vehicleInspection.model;

/**
 * Visar currentNumber
 */
public class Display {
    private int numberOnDisplay;
    
    /**
     * Skapar displayen och sätter den till 0
     */
    Display() {
        numberOnDisplay = 0;
    }
    
    /**
     * Byter vad som visas på skärmen
     * @param currentNumber Nya värdet som ska visas på skärmen
     */
    void showOnDisplay(int currentNumber) {
        this.numberOnDisplay = currentNumber;
        // VISA TEXT
    }
}
